import java.io.*;
import java.util.*;
public class ReverseSLLSegment {
    static class Node { 
        int data; 
        Node next; 
        Node(int data)  { 
        	this.data = data;  
        	this.next = null; 
        }
    } 
	static void printlnsll(Node head) { 
		Node t = head;
		while (t != null) { 
            System.out.print(t.data+" "); 
            t = t.next; 
        } 
        System.out.println();
    }

    static Node reverseSLL(Node head) {
        if(head == null)
            return head;
        Node t = head;
        Node next = null;
        Node prev = null;
        while(t != null) {
            next = t.next;
            t.next = prev;
            prev = t;
            t = next;
        }
        return prev;
    }

    static Node reverseSegment(Node head, int start, int end) {
        if(head == null || head.next == null || start == end)
            return head;
        Node t = head;
        Node left = head;
        Node right = head;
        Node prev = null;
        
        //reaching to start index
        for(int count = 0; count < start; count++) {
            prev = t;
            t = t.next;
        }
        left = t;

        //reaching to end index
        for( int count = 1; count < end ; count++) {
            t = t.next;
        }
        right = t;

        //detaching the segment
        Node rightNext = right.next;
        right.next = null;

       
        left = reverseSLL(left);

        //attaching the reversed list
        if(prev != null)
            prev.next = left;
        else
            head = left;

        for( t = left; t.next != null; )
            t = t.next;    
        t.next = rightNext;
        
       
        return head;
    }
    public static void main(String[] args) {
        Node head = null;
		Node temp = null; 
		
		for(int i = 1 ; i < 10; i++) {
			Node t = new Node(i);
			if(i == 1) {
				head = t;
				temp = t;
			} else {
				temp.next = t;
				temp = temp.next;
			}	
        }
        
        printlnsll(head);
        head = reverseSegment(head, 1, 3);
        printlnsll(head);
    }
}