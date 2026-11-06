package freshmart;

// MenuOption - the five options of the main menu.
// I used an enum so the menu can only have these options and nothing else.
public enum MenuOption {

    SORT(1, "Sort staff by name"),                                 // I will use Merge Sort here
    SEARCH(2, "Find one staff member"),                            // I will use Binary Search here
    ADD_RECORDS(3, "Add a new manager"),
    CREATE_BINARY_TREE(4, "Show the staff hierarchy as a tree"),
    EXIT(5, "Exit program");                                       // I put ; here because more code comes after the options

    // I keep the number the user types and the text shown in the menu
    private final int number;
    private final String description;   // I made them final because they never change

    // the constructor runs once for each option above, e.g. SORT(1, "Sort staff by name")
    MenuOption(int number, String description){
        this.number = number;           // this.number is the option's variable, number is the value sent
        this.description = description;
    }

    // I made the variables private, so the menu reads them with these getters
    public int getNumber() {
        return number;
    }
    public String getDescription(){
        return description;
    }

    // I look at each option until the number matches, or return null if none does
    public static MenuOption fromNumber(int number){
        for (MenuOption option : values()){
            if (option.getNumber() == number){
                return option;
            }
        }
        return null;
    }
}
