//Problem : https://www.geeksforgeeks.org/remove-leaf-nodes-binary-search-tree/
public class RemoveLeafNodesFromBinaryTree {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static Node leafDelete(Node root) {  
        if(root == null)
            return null;
        if (root.left == null && root.right == null)  
            return null;  
       
        root.left = leafDelete(root.left);  
        root.right = leafDelete(root.right);  
    
        return root;  
    } 
    static void printInOrder(Node root) {
        if(root == null)
            return;
                 
        printInOrder(root.left);
        System.out.print(root.data + " ");  
        printInOrder(root.right);
    }
    public static void main(String[] args) {
        Node root  = new Node(10); 
        root.left  = new Node(5); 
        root.right = new Node(50); 
        root.left.left  = new Node(1); 
        root.right.left = new Node(40); 
        root.right.right = new Node(100); 

        printInOrder(root);     
        leafDelete(root);
        System.out.println();
        printInOrder(root); 
    }
}