package freshmart;

import menu.MenuOption;
import java.util.Scanner;
import menu.InputValidator;
import menu.MenuActions;
import staff.StaffList;

// FreshMart - the main class. I start the program here and show the staff menu.
// 1. freshmart - FreshMart starts the program, FileLoader reads Applicants_Form.txt
public class FreshMart {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // I use it to read what the user types on the keyboard
        MenuOption choice;                      // I declared it outside the do-while so the while condition can see it

        Scanner fileReader = FileLoader.openFile(input); // I give my keyboard to FileLoader and get the open file back
        StaffList staffList = FileLoader.readStaff(fileReader); // Applicants_Form.txt
        System.out.println("Staff loaded: " + staffList.getCount());
        System.out.println("");
        StaffList newRecords = new StaffList(); // a second list only for the new records, outside the loop so it is not emptied each time

        do {    // I used a do-while because the menu has to show at least once, then repeat until EXIT

            MenuActions.showMenu(); // I print the title, the 5 options and the question

            int number = InputValidator.readMenuChoice(input, 5); // it only returns when the number is 1 to 5
            choice = MenuOption.fromNumber(number); // I turn the number into a menu option, it is never null here

            switch (choice) { // each case calls one method from MenuActions
                case SORT:
                    MenuActions.sortStaff(staffList);
                    break;

                case SEARCH:
                    MenuActions.searchStaff(input, staffList);
                    break;

                case ADD_RECORDS:
                    MenuActions.addRecords(input, staffList, newRecords);
                    break;

                case CREATE_BINARY_TREE:
                    MenuActions.createBinaryTree(staffList);
                    break;

                case EXIT:
                    System.out.println("Okay, Goodbye! ");
                    System.out.println("");
                    break;
            }
        } while (choice != MenuOption.EXIT);
    }
}
