package freshmart;

//Employee - the parent of every staff member
//It is abstract: nobody is just an employee, everyone is full-time, intern or contract
public abstract class Employee {

    // Data that every employee has (the child classes inherit it)
    private String name;
    private String email;
    private double salary;
    private String jobTitle;
    
    //CONSTRUCTOR = fills the attributes; public so the child classes can call it
    public Employee(String name, String email, double salary, String jobTitle){
        
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }
    
    // Getters: the attributes are private, so other classes read them here
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public String getJobTitle(){
        return jobTitle;
    }
}
