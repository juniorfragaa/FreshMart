package employee;

// ContractEmployee - I made this class for someone hired until a set end date
public class ContractEmployee extends Employee {

    private String endDate;    // I used String to keep it simple, e.g. "31/12/2026"

    public ContractEmployee(String name, String email, double salary, String jobTitle, String endDate){

        super(name, email, salary, jobTitle);    // the common data goes to Employee
        this.endDate = endDate;
    }

    public String getEndDate(){
        return endDate;
    }
}
