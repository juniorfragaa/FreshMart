package freshmart;

import java.util.Scanner;

public class FreshMart {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // reads what the user types on the keyboard
        MenuOption choice;                      // declared outside the do-while so the while condition can see it

        do {    // do-while: shows the menu at least once and repeats until EXIT
            System.out.println("==== FRESHMART STAFF MENU ===="); // title of the main menu

            // for-each loop: shows all the options from the enum, one by one
            for (MenuOption option : MenuOption.values()) { // values() gives all the options in order, so the menu text is written only once
                System.out.println(option.getNumber() + ". " + option.getDescription());
            }

            int typedNumber = -1;    // -1 = no valid number yet
            System.out.print("Choose an option (1-5): ");

            try {
                typedNumber = input.nextInt(); // try: this line fails if the user types letters
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                input.next(); // removes the wrong text, otherwise nextInt() would read it again forever
            }
            choice = MenuOption.fromNumber(typedNumber); //turns the typed number into a menu option (null if it is not on the menu)

            if (choice == null) { //check null first: a switch on null would crash the program
                System.out.println("Invalid option. Please choose 1 to 5.");
            } else { // a valid option was found, so run it
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
