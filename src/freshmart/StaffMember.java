package freshmart;

//StaffMember: I made this class to keep one simple record for each person,
// so the short, search and tree can all work on one list
public class StaffMember {
    
    private String name;
    private String designation; // the job tittle for staff, or the manager for managers
    private String department;
    
    public StaffMember(String name, String designation, String department){
        
        this.name = name;
        this.designation = designation;
        this.department = department;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDesignation(){
        return designation;
    }
    
    public String getDepartment(){
        return department;
    }
}
