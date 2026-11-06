package manager;

// TeamLead - I made this class for the manager who leads a small team
public class TeamLead extends Manager {

    private int teamSize;    // I used int because it is a number of people

    // I don't ask for the type because a team lead is always "Team Lead"
    public TeamLead(String name, int teamSize){

        super(name, "Team Lead");    // I send the name and the fixed type to Manager
        this.teamSize = teamSize;
    }

    public int getTeamSize(){
        return teamSize;
    }
}
