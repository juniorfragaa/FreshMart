package employee;

// Employee - I put the data that every staff member shares here, so I don't repeat it
// I made it abstract because nobody is just an employee: they are full-time, intern or contract
public abstract class Employee {

    // the 3 children inherit these
    private String name;
    private String email;
    private double salary;
    private String jobTitle;

    // I made the constructor public so the children can call it with super
    public Employee(String name, String email, double salary, String jobTitle){

        this.name = name;
        this.email = email;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    // I made the attributes private, so other classes read them with getters
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
