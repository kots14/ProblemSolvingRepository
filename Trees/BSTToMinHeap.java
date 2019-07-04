import java.util.ArrayList;

public class BSTToMinHeap {
    static int index = -1;
    static class Node {
        int data = Integer.MIN_VALUE;
        Node left = null;
        Node right = null;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static void printPreOrder(Node root) {
        if(root == null)
            return;
        
        System.out.print(root.data + " ");    
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    static void inorderTraversal(Node root, ArrayList<Integer> a) { 
        if (root == null) 
            return;   
        inorderTraversal(root.left, a);   
        a.add(root.data);   
        inorderTraversal(root.right, a); 
    } 
    static void bstToMinHeap(Node root, ArrayList<Integer> a) { 
        if (root == null) 
            return;   
        
        index += 1; 
        root.data = a.get(index);
           
        bstToMinHeap(root.left, a);  
        bstToMinHeap(root.right, a); 
    } 

    static void convertToMinHeap(Node root) { 
    
        ArrayList<Integer> a = new ArrayList<>(); 
        inorderTraversal(root, a); 
        bstToMinHeap(root, a); 
    } 
 
    public static void main(String[] args) {
        Node root = new Node(4); 
        root.left = new Node(2); 
        root.right = new Node(6); 
        root.left.left = new Node(1); 
        root.left.right = new Node(3); 
        root.right.left = new Node(5); 
        root.right.right = new Node(7); 
    
        convertToMinHeap(root); 
        printPreOrder(root);
    }
}