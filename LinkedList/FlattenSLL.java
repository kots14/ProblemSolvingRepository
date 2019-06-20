import java.util.*;
import java.io.*;

//Problem : https://www.geeksforgeeks.org/flatten-a-multi-level-linked-list-set-2-depth-wise/

public class FlattenSLL {
    static Node t = null;
    static class Node { 
        int data; 
        Node next; 
        Node down;
        Node(int data)  { 
        	this.data = data;  
            this.next = this.down = null; 
        }
    } 

    static void printFlattenedSLL(Node head) { 
		Node t = head;
		while (t != null) { 
            System.out.print(t.data+" "); 
            t = t.next; 
        } 
    } 

    static Node flattenSLL(Node n) {
        if(n == null)
            return null;
        t = n;
        Node nNext = n.next;
        if(n.down != null)
           n.next = flattenSLL(n.down);
        if(nNext != null)
           t.next = flattenSLL(nNext);
        return n;
        
    } 
    
    public static void main(String args[]) {
        Node head = null;
        
        //creating the multi level linked list
        head = new Node(1); 
        head.next = new Node(2); 
        head.next.next = new Node(3); 
        head.next.next.next = new Node(4); 
        head.next.down = new Node(7); 
        head.next.down.down = new Node(9); 
        head.next.down.down.down = new Node(14); 
        head.next.down.down.down.down = new Node(15); 
        head.next.down.down.down.down.next = new Node(23); 
        head.next.down.down.down.down.next.down = new Node(24); 
        head.next.down.next = new Node(8); 
        head.next.down.next.down = new Node(16); 
        head.next.down.next.down.down = new Node(17); 
        head.next.down.next.down.down.next = new Node(18); 
        head.next.down.next.down.down.next.next = new Node(19); 
        head.next.down.next.down.down.next.next.next 
                                        = new Node(20); 
        head.next.down.next.down.down.next.next.next.down 
                                        = new Node(21); 
        head.next.down.next.next = new Node(10); 
        head.next.down.next.next.down = new Node(11); 
    
        head.next.down.next.next.next = new Node(12); 

        head = flattenSLL(head);
        printFlattenedSLL(head);
    }
}