import java.io.*;
import java.util.*;

public class LowestCommonAncestorBST {
    static class Node { 
        int data; 
        Node left;
        Node right; 
        Node(int data)  { 
        	this.data = data;  
            this.left = null; 
            this.right = null;
        }
    }
    static Node lca(Node root, int n1, int n2) { 
        if (root == null) 
            return null; 
                
        //traverse in the left sub tree    
        if (root.data > n1 && root.data > n2) 
            return lca(root.left, n1, n2); 
    
        //traverse in the right sub tree    
        if (root.data < n1 && root.data < n2) 
            return lca(root.right, n1, n2); 
    
        //in order to handle the cases
        //(root.data > n1 && root.data < n2)
        // ||(root.data == n1 || root.data == n2 ) 
        // || (n1 == n2)   
        return root; 
    } 
     
    public static void main(String[] args) {
        Node root = new Node(40); 
        root.left = new Node(8); 
        root.right = new Node(50); 
    
        int n1 = 8;
        int n2 = 50; 
        Node t = lca(root, n1, n2); 
        System.out.printf("lca(%d ,%d) = %d \n", n1, n2, t.data); 
    }
}