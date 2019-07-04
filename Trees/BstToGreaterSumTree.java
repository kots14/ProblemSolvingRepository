public class BstToGreaterSumTree {
    static int sum = 0;
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static void printInOrder(Node root) {
        if(root == null)
            return;
                 
        printInOrder(root.left);
        System.out.print(root.data + " ");  
        printInOrder(root.right);
    }

    //using reverse inorder traversal
    static void transformTree(Node root) {
        if(root == null)
            return;
        transformTree(root.right);
        sum += root.data;
        root.data = sum - root.data;
        transformTree(root.left);
    }
    public static void main(String[] args) {
        Node root = new Node(11); 
        root.left = new Node(2); 
        root.right = new Node(29); 
        root.left.left = new Node(1); 
        root.left.right = new Node(7); 
        root.right.left = new Node(15); 
        root.right.right = new Node(40); 
        root.right.right.left = new Node(35); 
    
        printInOrder(root);     
        transformTree(root);
        System.out.println();
        printInOrder(root); 
    }
}