package freshmart;

// ContractEmployee: an employee hired until a set end date
public class ContractEmployee extends Employee {
    
    // only contract employees have an end date (e.g "31/12/2026")
    private String endDate;
    
    // receives the 4 parents attributes + its own end date
    public ContractEmployee(String name, String email, double salary, String jobTitle, String endDate){
        
        // super = send the common data to the Employee constructor (must be the first line)
        super(name, email, salary, jobTitle);
        this.endDate = endDate;
    }
    
    public String getEndDate(){
        return endDate;
    }
}
