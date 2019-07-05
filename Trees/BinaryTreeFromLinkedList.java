import java.io.*;
import java.util.*;
//Problem : https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
public class BinaryTreeFromLinkedList {
    static class TNode {
        int data;
        TNode left, right;
        public TNode(int i) {
            data = i;
            left = right = null;
        }
    }
    static class LNode {
        int data;
        LNode next;
        public LNode(int i) {
            data = i;
            next = null;
        }
    }
    static TNode convertSLLToBT(LNode head, TNode node)  { 
        // queue to store the parent nodes 
        Queue<TNode> q =  new LinkedList<TNode>(); 
   
        if (head == null) { 
            node = null;  
            return null; 
        } 
   
        node = new TNode(head.data); 
        q.add(node); 
   
        head = head.next; 
   
        TNode lc, rc;
        while (head != null) { 
            TNode parent = q.peek(); 
            TNode pp = q.poll(); 
               
            lc = rc = null; 
            lc = new TNode(head.data); 
            q.add(lc); 
            head = head.next; 
            if (head != null) { 
                rc = new TNode(head.data); 
                q.add(rc); 
                head = head.next; 
            } 
   
           
            parent.left = lc; 
            parent.right = rc; 
        } 
           
        return node; 
    }

    static LNode insertIntoSLL(LNode head, int d) {
        if(head == null)
            return new LNode(d);
        LNode t = head;    
        while(t.next != null) t = t.next;
         
        t.next = new LNode(d); 
        return head;
    }
    static void printPreOrder(TNode root) {
        if(root == null)
            return;
                         
        System.out.print(root.data + " ");  
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    public static void main(String[] args) {
        LNode head = new LNode(10);
        head = insertIntoSLL(head, 12); 
        head = insertIntoSLL(head, 15); 
        head = insertIntoSLL(head, 25);  
        head = insertIntoSLL(head, 30); 
        head = insertIntoSLL(head, 36);        
        
        TNode root = null;
        TNode node = convertSLLToBT(head, root); 
   
        printPreOrder(node);
    }
}