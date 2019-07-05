import java.io.*;
import java.util.*;
//Problem : https://www.geeksforgeeks.org/find-all-possible-trees-with-given-inorder-traversal/
public class AllPossibleBinaryTrees {
    static class Node {
        int data;
        Node left, right;
        public Node(int i) {
            data = i;
            left = right = null;
        }
    }
    static ArrayList<Node> getTrees(int a[], int start, int end) { 
  
        // List to store all possible trees 
        ArrayList<Node> trees= new ArrayList<>(); 
  
        // if start > end then subtree will be empty so 
        // returning null in the list 
        if (start > end) { 
            trees.add(null); 
            return trees; 
        } 
  
        for (int i = start; i <= end; i++) { 
            //creating left sub tree
            ArrayList<Node> lt = getTrees(a, start, i - 1);               
            //creating right sub tree
            ArrayList<Node> rt = getTrees(a, i + 1, end); 
  
            for (int j = 0; j < lt.size(); j++) { 
                for (int k = 0; k < rt.size(); k++) { 
  
                    // Making a[i] as root 
                    Node node = new Node(a[i]); 
  
                    // Connecting left subtree 
                    node.left = lt.get(j); 
  
                    // Connecting right subtree 
                    node.right = rt.get(k); 
  
                    // Adding this tree to list 
                    trees.add(node); 
                } 
            } 
        } 
        return trees; 
    } 
    static void printPreOrder(Node root) {
        if(root == null)
            return;
                         
        System.out.print(root.data + " ");  
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    public static void main(String[] args) {
        int a[] = {4, 5, 7}; 
        int N = a.length; 
     
        ArrayList<Node> trees = getTrees(a, 0, N - 1); 
        System.out.println("Preorder traversal of different "+ 
                           " binary trees are:"); 
        for (int i = 0; i < trees.size(); i++) { 
            printPreOrder(trees.get(i)); 
            System.out.println(); 
        }
    }
}