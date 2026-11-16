package manager;

// 5. manager - Manager and its 3 types, used when I add a new manager (option 3)
// Manager - I put the data that every manager shares here, so I don't repeat it
// I made it abstract because nobody is just a manager
public abstract class Manager {

    // the 3 children inherit these
    private String name;
    private String managerType;

    // I let each child send its own type, e.g. "Team Lead"
    public Manager(String name, String managerType){

        this.name = name;
        this.managerType = managerType;
    }

    // I made the attributes private, so other classes read them with getters
    public String getName(){
        return name;
    }

    public String getManagerType(){
        return managerType;
    }
}
