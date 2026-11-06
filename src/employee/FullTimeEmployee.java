package employee;

// FullTimeEmployee - I made this class for a permanent employee with a level
public class FullTimeEmployee extends Employee {

    private String level;    // I used String because the level is a word: junior, middle or senior

    public FullTimeEmployee(String name, String email, double salary, String jobTitle, String level){

        super(name, email, salary, jobTitle);    // I send the common data to Employee (super must be the first line)
        this.level = level;
    }

    public String getLevel(){
        return level;
    }
}
