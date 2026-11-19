package tree;

// NodeQueue: a queue of tree nodes (first in, first out)
// my tree uses it to visit the nodes level by level, from left to right
// I based it on the array queue from my lecturer's BinaryTreeTeaching
public class NodeQueue {

    private TreeNode[] items;    // the slots of the queue
    private int front;           // the position of the next node to leave
    private int rear;            // the next free position at the end
    
    public NodeQueue(){
        
        this.items = new TreeNode[100];
        this.front = 0;
        this.rear = 0; 
    }
    
    // a node joins the end of the queue (same idea as add in StaffList)
    public void enqueue(TreeNode node){
        items[rear] = node;
        rear++;
    }
    
    // the node at the front leaves the queue
    public TreeNode dequeue(){
        TreeNode node = items[front];    // I keep it first, because after front++ the front is the next one
        front++;
        return node;
    }
    
    // the queue is empty when front reaches rear
    public boolean isEmpty(){
        return front == rear;
    }
    
    public int size(){
        return rear - front;
    }
}
