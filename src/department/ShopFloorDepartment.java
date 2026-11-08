package department;

import manager.Manager; // I need it because Manager is in another package

// ShopFloorDepartment: I made this class for departments on the shop floor, like Checkout
public class ShopFloorDepartment extends Department {

    private int tillCount; // I used int because it is how many tills this department has
    
    public ShopFloorDepartment(String name, Manager manager, int tillCount){
        
        super(name, manager); // the name and the manager go to Department
        this.tillCount = tillCount;
    }
    
    public int getTillCount(){
        return tillCount;
    }
}
