import java.io.*;
import java.util.*;
//Problem : https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
public class DiagonalTraversalBinaryTree {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static void diagonalPrint(Node root,int d, HashMap<Integer,ArrayList<Integer>> hmap){ 
          
         // Base case 
        if (root == null) 
            return; 
          
        // get the list at the particular d value 
        ArrayList<Integer> k = hmap.get(d); 
          
        // k is null then create a vector and store the data 
        if (k == null) { 
            k = new ArrayList<>(); 
            k.add(root.data); 
        } 
          
        // k is not null then update the list 
        else 
            k.add(root.data);
          
        hmap.put(d,k); 
          
        diagonalPrint(root.left, d + 1, hmap); 
        diagonalPrint(root.right, d, hmap); 
    } 
      
    // Print diagonal traversal of given binary tree 
    static void diagonalPrint(Node root) { 
        
        HashMap<Integer,ArrayList<Integer>> hmap = new HashMap<>(); 
        diagonalPrint(root, 0, hmap); 
          
        System.out.println("Diagonal traversal");
        for (Map.Entry<Integer, ArrayList<Integer>> entry : hmap.entrySet()) { 
            System.out.println(entry.getValue()); 
        } 
    }
    public static void main(String[] args) {
        Node root = new Node(8); 
        root.left = new Node(3); 
        root.right = new Node(10); 
        root.left.left = new Node(1); 
        root.left.right = new Node(6); 
        root.right.right = new Node(14); 
        root.right.right.left = new Node(13); 
        root.left.right.left = new Node(4); 
        root.left.right.right = new Node(7); 
          
        diagonalPrint(root);
    }
}