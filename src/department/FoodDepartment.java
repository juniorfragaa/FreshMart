package department;

import manager.Manager;

// FoodDepartment: I made this class for departments that handle food, like Bakery
public class FoodDepartment extends Department{
    
    private boolean hygieneChecked; // I used boolean because the hygiene check is only yes or no

    public FoodDepartment(String name, Manager manager, boolean hygieneChecked) {
        
        super(name, manager);
        this.hygieneChecked = hygieneChecked;
    }
    
    public boolean isHygieneChecked(){ // "is" instead of "get", so it reads like a question
        return hygieneChecked;
    }
}
