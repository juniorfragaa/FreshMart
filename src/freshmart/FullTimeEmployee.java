package freshmart;

//FullTimeEmployee: a permant employee with a level (junior, middle or senior)
public class FullTimeEmployee extends Employee {
    
    // only full time employees have a level
    private String level;
   
    // Receives the 4 parent attributes + its own level
   public FullTimeEmployee(String name, String email, double salary, String jobTitle, String level){
       
       // super = send the common data to the Employee constructor (must be the first line)
       super(name, email, salary, jobTitle);
       this.level = level;
   }
   
   public String getLevel(){
       return level;
   }
}
