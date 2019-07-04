import java.io.*;
import java.util.*;
public class BinaryTreeToBinarySearchTree {
    static int index = 0;
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static int countNodes(Node root) {
        if(root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    static void storeInOrder(Node root, int[] a) {
        if(root == null)
            return;
        storeInOrder(root.left, a);
        a[index] = root.data;
        index += 1;
        storeInOrder(root.right, a);
    }
    static void arrayToBST(Node root, int[] a) {
        if(root == null)
            return;
        arrayToBST(root.left, a);
        root.data = a[index];
        index += 1;
        arrayToBST(root.right, a);
    }
    static Node binaryTreeToBinarySearchTree(Node root) {
        if(root == null)
            return root;
        int N = countNodes(root);
        int[] a = new int[N];
        index = 0;
        storeInOrder(root, a);   
        
        Arrays.sort(a); 
        
        index = 0;
        arrayToBST(root, a);

        return root;
    }
    static void printInOrder(Node root) {
        if(root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(10); 
        root.left = new Node(30); 
        root.right = new Node(15); 
        root.left.left = new Node(20); 
        root.right.right = new Node(5); 
  
        // convert Binary Tree to BST 
        root = binaryTreeToBinarySearchTree(root); 
  
        printInOrder(root); 
    }
}