package employee;

// InternEmployee - I made this class for a student on an internship
public class InternEmployee extends Employee {

    private int months;    // I used int because it is how many months the internship lasts

    public InternEmployee(String name, String email, double salary, String jobTitle, int months){

        super(name, email, salary, jobTitle);    // the name, email, salary and job title go to Employee
        this.months = months;
    }

    public int getMonths(){
        return months;
    }
}