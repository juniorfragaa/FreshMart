package freshmart;

// InterEmployee: a student on an internship for a number of months
public class InternEmployee extends Employee {
    
    // only interns have months (how long the intership lasts)
    private int months;
    
    // recieves the 4 parents attributes + its own months
    public InternEmployee(String name, String email, double salary, String jobTitle, int months){
        
        super(name, email, salary, jobTitle);
        this.months = months;
    }
    
    public int getMonths(){
        return months;
    }           
}

