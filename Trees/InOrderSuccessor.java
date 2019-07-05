public class InOrderSuccessor {
    static class Node {
        int data;
        Node parent, left, right;
        public Node(int i) {
            data = i;
            parent = left = right = null;
        }
    }
    static Node minValue(Node node) { 
        Node current = node; 
        //since it's a BST, min value will be in left sub tree    
        while (current != null && current.left != null) { 
            current = current.left; 
        } 
        return current; 
    } 
    static Node inOrderSuccessor( Node root, Node n) { 
        // step 1 of the above algorithm 
        if( n != null && n.right != null ) 
            return minValue(n.right); 
    
        Node successor = null; 
    
        // Start from root and search for successor down the tree 
        while (root != null) { 
            if (n.data < root.data) { 
                successor = root; 
                root = root.left; 
            } 
            else if (n.data > root.data) 
                root = root.right; 
            else
                break; 
        } 
    
        return successor; 
    } 
    static Node insertIntoBST(Node node, int data) {
        if(node == null)
            return new Node(data);

        Node temp;   
  
        if (data <= node.data) {     
            temp = insertIntoBST(node.left, data); 
            node.left  = temp; 
            temp.parent= node; 
        }  else { 
            temp = insertIntoBST(node.right, data); 
            node.right = temp; 
            temp.parent = node; 
        }     

        return node;    
    }
    public static void main(String[] args) {
        Node root = new Node(20); 
        root = insertIntoBST(root, 8); 
        root = insertIntoBST(root, 22); 
        root = insertIntoBST(root, 4); 
        root = insertIntoBST(root, 12); 
        root = insertIntoBST(root, 10);   
        root = insertIntoBST(root, 14);     
        Node temp = root.left.right.right; 
        
        Node successor =  inOrderSuccessor(root, temp);
        System.out.println(temp.data+" "+successor.data);
    }
}