package manager;

// HeadManager - I made this class for the manager in charge of the whole store
public class HeadManager extends Manager {

    private String storeName;    // I keep the name of the store this manager runs

    public HeadManager(String name, String storeName){

        super(name, "Head Manager");    // a head manager is always "Head Manager"
        this.storeName = storeName;
    }

    public String getStoreName(){
        return storeName;
    }
}
