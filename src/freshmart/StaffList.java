package freshmart;

// StaffList: I made this class to keep every StaffMember in one list,
// so the sort, search, add and tree all use the same list
public class StaffList {

    private StaffMember[] members;    // the slots for the records
    private int count;                // how many records there are, and the next free slot

    // I create 100 empty slots: 30 from the file and space for new records
    public StaffList(){

        this.members = new StaffMember[100];
        this.count = 0;
    }

    public int getCount(){
        return count;
    }

    // I give back the record in this slot, e.g. getMember(0) is the first one
    public StaffMember getMember(int index){
        return members[index];
    }

    // I add a record in the next free slot (same idea as addEmployee in Department)
    public void add(StaffMember m){
        if (count == members.length){    // I check first if all 100 slots are used
            System.out.println("The staff list is full.");
            return;
        }
        members[count] = m;
        count++;
    }
}
