package freshmart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// FileLoader - I made this class to open and read the staff file, so the main menu stays short
public class FileLoader {

    // I receive the keyboard from main and give back the open file
    public static Scanner openFile(Scanner myKB){    // myKB = my keyboard, the Scanner from main

        Scanner reader = null;    // null = no file opened yet, so the loop keeps asking

        do {
            System.out.print("Please enter the filename to read: ");
            String fileName = myKB.nextLine().trim();    // I use trim() in case the user types extra spaces

            try {
                reader = new Scanner(new File(fileName));    // Java looks for this file in the project folder
                System.out.println("File read successfully");
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please check the name and try again.");
            }
        } while (reader == null);

        return reader;
    }
    
    public static StaffList readStaff(Scanner fileReader){
        
        StaffList list = new StaffList();
        fileReader.nextLine();
        
        while(fileReader.hasNextLine()){
            
            String staffLine = fileReader.nextLine();
            
            if(staffLine.trim().isEmpty()){
                continue;
            }
            
            String[] columns = staffLine.split(",");
            String firstName = columns[0].trim();
            String lastName = columns[1].trim();
            String gender = columns[2].trim();
            String email = columns[3].trim();
            double salary = Double.parseDouble(columns[4].trim());
            String department = columns[5].trim();
            String position = columns[6].trim();
            String jobTitle = columns[7].trim();
            
            list.add(new StaffMember(firstName + " " + lastName, jobTitle, department));
        }
        return list;
    }
}
