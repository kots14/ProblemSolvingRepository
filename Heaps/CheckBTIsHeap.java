public class CheckBTIsHeap {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    private static int countTreeNodes(Node root) {
        if(root == null)
            return 0;
        return ( 1 + countTreeNodes(root.left) + countTreeNodes(root.right));
    }

    private static boolean isBinaryTreeComplete(Node root, int i, int nodes) {
        if(root == null)
            return true;
        if(i >= nodes)
            return false;
        return isBinaryTreeComplete(root.left, 2 * i + 1, nodes) && isBinaryTreeComplete(root.right, 2 * i + 2, nodes);
    }

    private static boolean isHeap(Node root) {
        if(root == null)
            return true;
        
        //for leaf node return true
        if(root.left == null && root.right == null) 
            return true;
   
        //checking if left child is greater than root.data
        if(root.data < root.left.data)
            return false;

        //checking if right child is greater than root.data   
        if(root.right != null && root.data < root.right.data)
            return false;

        return (isHeap(root.left) && isHeap(root.right));
    }

    static boolean isBinaryTreeHeap(Node root) {
        return isBinaryTreeComplete(root, 0, countTreeNodes(root)) && isHeap(root);   
    }
    public static void main(String[] args) {
        Node root = new Node(10); 
        root.left = new Node(9); 
        root.right = new Node(8); 
        root.left.left = new Node(7); 
        root.left.right = new Node(6); 
        root.right.left = new Node(5); 
        root.right.right = new Node(4); 
        root.left.left.left = new Node(3); 
        root.left.left.right = new Node(2); 
        root.left.right.left = new Node(1);
    
        boolean output = isBinaryTreeHeap(root); 
           
        System.out.println("Is heap : " + output);
    }
}