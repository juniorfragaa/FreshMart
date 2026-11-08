package department;

import manager.Manager;

// SupportDepartment: I made this class for back-office departments, like HR and Warehouse
public class SupportDepartment extends Department {

    private String officeLocation; // where the office is, e.g. "First floor"

    public SupportDepartment(String name, Manager manager, String officeLocation) {
        
        super(name, manager);
        this.officeLocation = officeLocation;
    }
    
    public String getOfficeLocation(){
        return officeLocation;
    }
}
