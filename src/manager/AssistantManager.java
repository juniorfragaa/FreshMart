package manager;

// AssistantManager - I made this class for the manager who helps the head manager
public class AssistantManager extends Manager {

    private String shift;    // I used String because the shift is a word, e.g. "Morning"

    public AssistantManager(String name, String shift){

        super(name, "Assistant Manager");    // I write the type here so it can't be wrong
        this.shift = shift;
    }

    public String getShift(){
        return shift;
    }
}
