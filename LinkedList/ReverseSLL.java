import java.io.*;
import java.util.*;

//Problem : Reverse a Linked list

public class ReverseSLL {
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
    public static void main(String[] args) {
        //making the linked list
		Node head = null;
		Node temp = null; 
		
		for(int i = 1 ; i < 6; i++) {
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
        head = reverseSLL(head);
        printlnsll(head);
    }
}