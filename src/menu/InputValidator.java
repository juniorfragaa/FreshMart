package menu;

import java.util.Scanner;

// InputValidator: I check everything the user types, so the program never crashes
// and keeps asking until the answer is valid
public class InputValidator {

    // I keep asking until the user types a number from 1 to max
    // I use max so the same method works for the manager type (1-3) and the department (1-7)
    public static int readMenuChoice(Scanner myKB, int max){

        int choice = -1;    // I start at -1 because it is outside 1 to max (no valid number yet)

        do{    // do-while because I always need to ask at least once
            try{
                choice = myKB.nextInt(); // this line fails if the user types letters, so I put it in a try
            }catch (Exception e){
                myKB.next(); // I remove the wrong text, otherwise nextInt() would read it again forever
            }
            if(choice < 1 || choice > max){    // too small OR too big
                System.out.print("Invalid choice. Please enter 1 to " + max + ": ");
            }

        } while(choice < 1 || choice > max);    // I repeat while the number is outside 1 to max

        return choice;    // if I get here, the number is valid
    }

    // I keep asking until the name is not empty and has no numbers
    public static String readName(Scanner myKB){

        String name = "";
        boolean valid = false;    // it only becomes true when the name passes both rules

        do{
            name = myKB.nextLine().trim();    // trim() removes spaces at the ends, so only spaces counts as empty
            boolean hasNumber = false;        // like a light: off until I find a digit

            // I check each letter of the name, one by one
            for (int i = 0; i < name.length(); i++){
                if(Character.isDigit(name.charAt(i))){
                    hasNumber = true;
                }
            }

            if (name.isEmpty()){
                System.out.println("Name cannot be empty");
                System.out.println("");
                System.out.print("Enter the manager's full name: ");
                
            } else if (hasNumber){
                System.out.println("Name cannot contain numbers");
                System.out.println("");
                System.out.print("Enter the manager's full name: ");
                
            } else {
                valid = true;    // both rules passed, so the loop can stop
            }
        } while(!valid);    // ! means "not": I repeat while the name is not valid

        return name;
    }
}
