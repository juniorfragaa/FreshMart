package freshmart;

// MenuOption - the five options of the main menu.
// It is an enum, so the menu can only have these options and nothing else.
public enum MenuOption {
    
    SORT(1, "Sort staff by name"),                                 // sort the staff by name (Merge Sort)
    SEARCH(2, "Find one staff member"),                            // find one staff member (Binary Search) 
    ADD_RECORDS(3, "Add a new manager"),                           // add a new manager
    CREATE_BINARY_TREE(4, "Show the staff hierarchy as a tree"),  // show the staff hierarchy as a tree
    EXIT(5, "Exit program");                                       // close the program (; because more code comes after)
    // Each option keeps the number the user types and the text shown in the menu
    private final int number;
    private final String description;   // final = it never changes after it is set
    
    // CONSTRUCTOR = runs once for each option above, e.g. SORT(1, "Sort staff by name")
    MenuOption(int number, String description){
        this.number = number;           // this. = the option's variable, number = the value sent        
        this.description = description;
    }
    
    // Getters: the variables are private, so the menu reads them through these methods
    public int getNumber() { 
        return number;
    }
    public String getDescription(){
        return description;
    }
    
    // Finds the option with this number, or null if there is none
    public static MenuOption fromNumber(int number){
        for (MenuOption option : values()){
            if (option.getNumber() == number){
                return option;
            }    
        }
        return null;
    }
}

