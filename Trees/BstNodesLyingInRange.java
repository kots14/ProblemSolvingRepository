//Problem : https://www.geeksforgeeks.org/count-bst-nodes-that-are-in-a-given-range/
public class BstNodesLyingInRange {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static int getCount(Node root, int low, int high) { 
        if(root == null) return 0; 
    
        if(root.data == high && root.data == low) 
            return 1; 
    
        if(root.data <= high && root.data >= low) 
            return 1 + getCount(root.left, low, high) + 
                        getCount(root.right, low, high); 
    
        //go to right if current is smaller than low
        else if (root.data < low) 
            return getCount(root.right, low, high); 
    
        return getCount(root.left, low, high); 
    }
    public static void main(String[] args) {
        Node root  = new Node(10); 
        root.left  = new Node(5); 
        root.right = new Node(50); 
        root.left.left  = new Node(1); 
        root.right.left = new Node(40); 
        root.right.right = new Node(100); 
    
        int l = 5; 
        int h = 45; 
        System.out.print("[" + l + ", " + h 
         + "] : " + getCount(root, l, h));
    }
}