package department;

import employee.Employee;
import manager.Manager;     // I import Manager because it is in another package

// 6. department - the inheritance model from my class diagram
// Department: I put the data that every department shares here
// I made it abstract because nobody works in just a "department", it is Bakery, HR, Checkout..
public abstract class Department { 

    private String name;
    private Manager manager;    // I keep a whole Manager object here because a department HAS A manager
    private Employee[] staff;   // I use an array to keep the people who work in this
    private int staffCount;     // how many people are in the array, and also the next free slot
    
    // I receive the department name and the manager who runs it
    public Department(String name, Manager manager){
        
        this.name = name;
        this.manager = manager;   
        this.staff = new Employee[50]; // I create 50 empty slots, enough for the file and new records
        this.staffCount = 0;           // nobody yet
    }
    
    // I made the attributes private, so other classes read them with getters
    public String getName(){
        return name;
    }
    
    public Manager getManager(){ // it gives back the whole manager e.g. bakery.getManager().getName()
        return manager;
    }
    
    //I add a person to this department, in the next free slot
    public void addEmployee (Employee e){
        if (staffCount == staff.length){    // I check first if all 50 slots are used
            System.out.println("This department is full.");
            return;            // I stop here, so nobody is added
        }
        staff[staffCount] = e; // staffCount is always the next free slot
        staffCount++;          // one more person in the department
    }
    
    // I return how many people work in this department
    public int getStaffCount(){
        return staffCount;
    }
}
