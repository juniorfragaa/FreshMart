package tree;

import staff.StaffList;
import staff.StaffMember;

// 4. tree - TreeNode, NodeQueue and StaffTree build the hierarchy for option 4
// StaffTree: I keep the staff hierarchy as a binary tree (each node has at most 2 children)
// I fill it level by level, from left to right, so the managers I insert first stay at the top
public class StaffTree {

    private TreeNode root;      // the top of the tree, private so only my methods can change it

    public StaffTree(){
        this.root = null;       // the tree starts empty
    }

    // I add a new member in the first free place, level by level (level-order)
    // O(n), because in the worst case I visit every node before I find a free place
    public void insert(StaffMember member){

        TreeNode newNode = new TreeNode(member);    // I wrap the member in a new node

        if(root == null){               // case 1: empty tree, the new node becomes the root
            root = newNode;
            return;
        }

        NodeQueue queue = new NodeQueue();  // case 2: I use a queue to visit the nodes in level order

        queue.enqueue(root);            // I start from the root, otherwise the while never runs

        while(!queue.isEmpty()){
            TreeNode current = queue.dequeue();     // I take the next node to check

            if(current.getLeft() == null){          // free place on the left
                current.setLeft(newNode);           // I attach the new node here
                return;                             // done, I stop looking
            } else {
                queue.enqueue(current.getLeft());   // taken, so I check that child later
            }

            if(current.getRight() == null){         // same idea for the right side
                current.setRight(newNode);
                return;
            } else {
                queue.enqueue(current.getRight());
            }
        }
    }

    // I print the tree level by level, using the same queue idea as insert()
    // O(n), because I print every node once
    public void displayLevelOrder(){

        if(root == null){
            System.out.println("Tree is empty");
            return;
        }

        NodeQueue queue = new NodeQueue();
        queue.enqueue(root);

        while(!queue.isEmpty()){

            TreeNode current = queue.dequeue();     // the node for this turn
            StaffMember member = current.getData(); // the staff member inside the node

            System.out.println(member.getName() + " - " +
                    member.getDesignation() + " - " + member.getDepartment());

            if(current.getLeft() != null){          // I only put real children in the queue
                queue.enqueue(current.getLeft());
            }

            if(current.getRight() != null){
                queue.enqueue(current.getRight());
            }
        }
    }

    // Recursive: the height of a node is 1 + the height of its taller side
    // O(n), because I visit every node once
    private int height(TreeNode node){
        if(node == null){       // base case: an empty node has height 0, so the recursion stops
            return 0;
        }

        int leftHeight = height(node.getLeft());    // I ask the left side for its height
        int rightHeight = height(node.getRight());  // I ask the right side for its height

        return 1 + Math.max(leftHeight, rightHeight);   // me + the taller side
    }

    // root is private, so this public method starts the recursion from the root
    public int getHeight(){
        return height(root);
    }

    // Recursive: the number of nodes is me + all nodes on the left + all nodes on the right
    // O(n), because I visit every node once
    private int countNodes(TreeNode node){
        if(node == null){       // base case: an empty node counts as 0
            return 0;
        }

        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }

    // public entry point, same reason as getHeight()
    public int getNodeCount(){
        return countNodes(root);
    }

    // I turn the designation into a number, so I can insert the higher ranks first
    private int getRank(String designation){
        if(designation.equalsIgnoreCase("Head Manager")){
            return 1;
        }
        if(designation.equalsIgnoreCase("Assistant Manager")){
            return 2;
        }
        if(designation.equalsIgnoreCase("Team Lead")){
            return 3;
        }
        return 4;               // anyone else is regular staff
    }
    
    // I build the tree from the staff list, inserting the higher ranks first so they stay at the top
    // I go through the list 4 times, once per rank
    public void buildTree(StaffList list){
        root = null;                                    // I start empty, so nobody is added twice if option 4 runs again
        for(int rank = 1; rank <= 4; rank++){           // 1 Head Manager, 2 Assistant Manager, 3 Team Lead, 4 staff
            for(int i = 0; i < list.getCount(); i++){   // I check every member in the list
                StaffMember member = list.getMember(i);
                if(getRank(member.getDesignation()) == rank){   // I only insert the members of this rank
                    insert(member);
                }
            }
        }
    }
}

