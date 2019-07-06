import java.io.*;
import java.util.*;
public class MaxDepthOfTree {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static int maxDepthOfTree(Node root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepthOfTree(root.left), maxDepthOfTree(root.right));
    }
    public static void main(String[] args) {
        Node root = new Node(1);  
  
        root.left = new Node(2);  
        root.right = new Node(3);  
        root.left.left = new Node(4);  
        root.left.right = new Node(5);  
        
        System.out.println("maxDepth: "+maxDepthOfTree(root));    

    }
}