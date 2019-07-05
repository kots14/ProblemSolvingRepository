//Problem : https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
public class AddGreaterValuesInBinaryTree {
    static int sum = 0;
    static class Node {
        int data;
        Node left, right;
        public Node(int i) {
            data = i;
            left = right = null;
        }
    }
    static void transformBST(Node root) {
        if(root == null)
            return;
        transformBST(root.right);
        sum += root.data;
        root.data = sum - root.data;
        transformBST(root.left);
    }
    static void printInOrder(Node root) {
        if(root == null)
            return;
                 
        printInOrder(root.left);
        System.out.print(root.data + " ");  
        printInOrder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        transformBST(root);
        printInOrder(root);
    }
}