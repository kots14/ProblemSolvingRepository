import java.io.*;
import java.util.*;
public class BinaryTreeCompleteness {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static int countTreeNodes(Node root) {
        if(root == null)
            return 0;
        return ( 1 + countTreeNodes(root.left) + countTreeNodes(root.right));
    }

    static boolean isBinaryTreeComplete(Node root, int i, int nodes) {
        if(root == null)
            return true;
        if(i >= nodes)
            return false;
        return isBinaryTreeComplete(root.left, 2 * i + 1, nodes) && isBinaryTreeComplete(root.right, 2 * i + 2, nodes);
    }
    public static void main(String[] args) {
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.right = new Node(6); 
    
        int N = countTreeNodes(root); 
        boolean output =isBinaryTreeComplete(root, 0, N); 
           
        System.out.println("Is Binary tree complete : " + output);
    }
}