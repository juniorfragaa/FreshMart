package menu;

import staff.StaffList;
import staff.StaffMember;
import java.util.Scanner;
import manager.AssistantManager;
import manager.HeadManager;
import manager.Manager;
import manager.TeamLead;
import tree.StaffTree;

// 2. menu - MenuOption has the 5 options, MenuActions runs each one, InputValidator checks what the user types
// MenuActions: I keep the code of each menu option here, so main only shows the menu
// all methods are static, so main calls them with the class name (MenuActions.sortStaff)
public class MenuActions {

    // main menu: I show the options and ask the question, main only reads the answer
    public static void showMenu() {
        System.out.println("==== FRESHMART STAFF MENU ===="); // title of the main menu

        // I print the menu with a for-each over values(), so the text only lives in the enum
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getNumber() + ". " + option.getDescription());
        }

        System.out.println("");
        System.out.print("Choose an option (1-5): "); // outside the for, so I ask only once
    }

    // option 1: I sort the staff A to Z and show the first 20
    public static void sortStaff(StaffList staffList) {
        System.out.println("SORT selected");
        System.out.println("");
        staffList.sortByName(); // I sort the list A to Z with my Merge Sort
        System.out.println("Staff sorted A to Z (first 20):");
        for (int i = 0; i < 20; i++) {    // the brief asks to show only the first 20
            System.out.println((i + 1) + ". " + staffList.getMember(i).getName());
        }
        System.out.println("");
    }

    // option 2: I find one person by full name
    // I receive the keyboard from main, because a second Scanner on System.in would mix up the input
    public static void searchStaff(Scanner input, StaffList staffList) {
        System.out.println("SEARCH selected");
        System.out.println("");
        staffList.sortByName(); // Binary Search only works on a sorted list, so I sort first
        System.out.print("Enter the full name to search: ");

        input.nextLine(); // I clear the Enter left by nextInt(), otherwise the name comes empty

        String searchName;

        searchName = input.nextLine(); // nextLine() reads the full name with the space

        if (searchName.isEmpty()) {
            System.out.println("Name cannot be empty");

        } else {
            int position = staffList.searchByName(searchName); // the position, or -1 if not found
            if (position == -1) {
                System.out.println("Staff member not found");
            } else {
                System.out.println("Found: "
                        + staffList.getMember(position).getName() + " - "
                        + staffList.getMember(position).getDesignation() + " - "
                        + staffList.getMember(position).getDepartment());
            }
        }
        System.out.println("");
    }

    // option 3: I add a new manager with a validated name, type and department
    // newRecords comes from main, so the list keeps every new record between menu choices
    public static void addRecords(Scanner input, StaffList staffList, StaffList newRecords) {
        System.out.println("ADD RECORDS selected");
        System.out.println("");

        input.nextLine(); // I clear the Enter left by nextInt(), same as in SEARCH
        System.out.print("Enter the manager's full name: ");

        String newName = InputValidator.readName(input); // it keeps asking until the name is not empty and has no numbers
        System.out.println("");
        System.out.println("1. Head Manager");
        System.out.println("2. Assistant Manager");
        System.out.println("3. Team Lead");
        System.out.println("");
        System.out.print("Choose manager type (1-3): ");

        int typeChoice = InputValidator.readMenuChoice(input, 3); // only 1, 2 or 3 can pass
        Manager newManager; // a Manager box can hold any child, so I create the one the user chose

        // the extra values (store, shift, team size) are not in the file, so I use example values
        if (typeChoice == 1) {
            newManager = new HeadManager(newName, "Junior's FreshMart");
        } else if (typeChoice == 2) {
            newManager = new AssistantManager(newName, "Morning");
        } else {    // else instead of else if, so Java knows newManager always gets a value
            newManager = new TeamLead(newName, 5);
        }

        // only these 7 departments exist, written the same as in the file
        String[] departments = {"Checkout", "Bakery", "Butchery", "Fresh Produce", "Warehouse", "Customer Service", "HR"};

        System.out.println("");
        for (int i = 0; i < departments.length; i++) {    // i + 1 because the user sees 1 to 7
            System.out.println((i + 1) + ". " + departments[i]);
        }
        System.out.println("");
        System.out.print("Choose department (1-7): ");

        int deptChoice = InputValidator.readMenuChoice(input, departments.length); // the array knows it has 7
        String newDepartment = departments[deptChoice - 1]; // - 1 because the array starts at 0

        // the object gives me its own type text (Head Manager, Assistant Manager or Team Lead)
        StaffMember newMember = new StaffMember(newName, newManager.getManagerType(), newDepartment);

        staffList.add(newMember);     // in the main list, so SORT and SEARCH can find it too
        newRecords.add(newMember);    // in the new list, so I can show all the new records

        System.out.println("");
        System.out.println(newName + " has been added as " + newManager.getManagerType() + " to " + newDepartment + " successfully!");
        System.out.println("");
        System.out.println("New records added: ");

        for (int i = 0; i < newRecords.getCount(); i++) {    // every record added so far, not only the last one
            System.out.println(newRecords.getMember(i).getName() + " - "
                    + newRecords.getMember(i).getDesignation() + " - "
                    + newRecords.getMember(i).getDepartment());
        }
        System.out.println("");
    }

    // option 4: I build the staff tree and show it in level order, with its height and node count
    public static void createBinaryTree(StaffList staffList) {
        System.out.println("CREATE BINARY TREE selected");
        System.out.println("");

        StaffTree tree = new StaffTree();   // a new empty tree
        tree.buildTree(staffList);          // I insert everyone, managers first, so they stay at the top

        System.out.println("Level order traversal: ");
        tree.displayLevelOrder();           // void, it prints by itself, so it cannot go inside println
        System.out.println("");

        System.out.println("Tree height: " + tree.getHeight());     // how many levels the tree has
        System.out.println("Total nodes: " + tree.getNodeCount());  // how many people are in the tree
        System.out.println("");
    }
}
