package freshmart;

import java.util.Scanner;

// FreshMart - the main class. I start the program here and show the staff menu.
public class FreshMart {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // I use it to read what the user types on the keyboard
        MenuOption choice;                      // I declared it outside the do-while so the while condition can see it

        Scanner fileReader = FileLoader.openFile(input); // I give my keyboard to FileLoader and get the open file back
        StaffList staffList = FileLoader.readStaff(fileReader); // Applicants_Form.txt
        System.out.println("Staff loaded: " + staffList.getCount());
        
        do {    // I used a do-while because the menu has to show at least once, then repeat until EXIT
            System.out.println("==== FRESHMART STAFF MENU ===="); // title of the main menu

            // I print the menu with a for-each over values(), so the text only lives in the enum
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option.getNumber() + ". " + option.getDescription());
            }

            int typedNumber = -1;    // I start at -1 because it is not on the menu (no valid number yet)
            System.out.print("Choose an option (1-5): ");

            try {
                typedNumber = input.nextInt(); // this line fails if the user types letters, so I put it in a try
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                input.next(); // I remove the wrong text, otherwise nextInt() would read it again forever
            }
            choice = MenuOption.fromNumber(typedNumber); // I turn the number into a menu option (null if it is not on the menu)

            if (choice == null) { // I check null first because a switch on null would crash the program
                System.out.println("Invalid option. Please choose 1 to 5.");
            } else { // here I know the option is valid, so I run it
                switch (choice) {
                    case SORT:
                        System.out.println("SORT selected");
                        System.out.println("");
                        break;

                    case SEARCH:
                        System.out.println("SEARCH selected");
                        System.out.println("");
                        break;

                    case ADD_RECORDS:
                        System.out.println("ADD RECORDS selected");
                        System.out.println("");
                        break;

                    case CREATE_BINARY_TREE:
                        System.out.println("CREATE BINARY TREE selected");
                        System.out.println("");
                        break;

                    case EXIT:
                        System.out.println("Okay, Goodbye! ");
                        System.out.println("");
                        break;
                }
            }
        } while (choice != MenuOption.EXIT);
    }
}
