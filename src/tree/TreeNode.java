package tree;

import staff.StaffMember;

// TreeNode: one box of my binary tree
// it keeps one staff member and points to the two boxes below it
public class TreeNode {

    private StaffMember data;    // the staff member (name, designation and department are inside)
    private TreeNode left;       // the child on the left
    private TreeNode right;      // the child on the right
    
    // a new node starts with no children, so left and right are null (nobody there)
    public TreeNode(StaffMember data){
        
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public StaffMember getData(){
        return data;
    }
    
    public TreeNode getLeft(){
        return left;
    }
    
    public TreeNode getRight(){
        return right;
    }
    
    // I only need setters for the children, because the tree adds them later
    public void setLeft(TreeNode node){
        this.left = node;
    }
    
    public void setRight(TreeNode node){
        this.right = node;
    }
}
