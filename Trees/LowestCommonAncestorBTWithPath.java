import java.io.*;
import java.util.*;

public class LowestCommonAncestorBTWithPath {
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
    static ArrayList<Node> p = new ArrayList<>();
    static boolean flag = true;
    static void traverse(Node root, int k) {
       
        if( root == null) return;
        
        p.add(root);
        
        if(root.data == k) {
            flag = false;
            return; 
        }
        if(root.left != null && flag)
            traverse(root.left, k);
        if(root.right != null && flag)
            traverse(root.right, k);
     
    }
    static Node lca(Node root, int n1, int n2) { 
        ArrayList<Node> left = new ArrayList<>();
        traverse(root, n1);       
        for(Node n : p) { left.add(n);}
        p.clear();
        flag = true;

        System.out.println();
        ArrayList<Node> right = new ArrayList<>();
        traverse(root, n2);
        for(Node n : p) { right.add(n);}
        p.clear();
        flag = true;

        if(left == null || right == null)
            return root;
        int i = 0; 
        while( i < left.size() && i < right.size() ) { 
            if (left.get(i).data != right.get(i).data) 
                break; 
            i += 1;   
        }
       
        if(left.get(i - 1).data == n1 || left.get(i - 1).data == n2)
            return left.get(i - 2);
        return left.get(i - 1) ;
    }
    public static void main(String[] args) {
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7);
    
        int n1 = 4;
        int n2 = 5; 
        Node t = lca(root, n1, n2); 
        System.out.printf("\nlca(%d ,%d) = %d \n", n1, n2, t.data); 

        root = new Node(40); 
        root.left = new Node(80); 
        root.right = new Node(50); 
    
        n1 = 80;
        n2 = 50; 
        t = lca(root, n1, n2); 
        System.out.printf("lca(%d ,%d) = %d \n", n1, n2, t.data); 
    }
}