public class LowestCommonAncestorBT {
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

    static Node lca(Node root, int n1, int n2) { 
        if(root == null)
            return null;
        
        if(root.data == n1 || root.data == n2)
            return root;
        
        
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left != null && right != null)
            return root;
        
        if(left != null)
            return left;
        
        //if right is not null return right     
        return right;
    } 
    public static void main(String[] args) {
        Node root = new Node(40); 
        root.left = new Node(80); 
        root.right = new Node(50); 
    
        int n1 = 80;
        int n2 = 50; 
        Node t = lca(root, n1, n2); 
        System.out.printf("lca(%d ,%d) = %d \n", n1, n2, t.data); 
    }
}