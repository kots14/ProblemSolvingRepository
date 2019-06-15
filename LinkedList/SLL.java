import java.io.*;
import java.util.*;

public class SLL {
	
	static class Node { 
        int data; 
        Node next; 
        Node(int data)  { 
        	this.data = data;  
        	this.next = null; 
        }
    } 
	static void printsll(Node head) { 
		Node t = head;
		while (t != null) { 
            System.out.print(t.data+" "); 
            t = t.next; 
        } 
    } 
	static Node swapTailAndHead(Node head) {
		Node t = head;
		Node secondLast = null;
		
		if(t == null)
			return head;
		if(t!=null)
			if(t.next == null)
				return head;
		
		//setting the tail and second last node
		while(t.next != null) {
			if(t.next.next == null)
				secondLast = t;  
			t = t.next;
		}
		Node tail = t;
		
		secondLast.next = null;
		tail.next = head;
		head = tail;
		tail = secondLast;
		
		return head;
	}
	static Node insertInSortedSLL(Node head, Node d) {
		
		Node t = head;
		Node left = null;
		Node right = null;
		if(t == null) {
			head = d;
			return head;
		}
		if(t!=null) {
			if(t.next == null) {
				if(t.data >= d.data) {
					d.next = t;
					head = d;
					return head;
				}
				if(t.data <= d.data) {
					t.next = d;
					return head;
				}
			}
		}
		
		while(t != null) {
			left = t;
			right = t.next; 
			if(left.data <= d.data) {
				if( right == null) {
					 left.next = d;
					 return head;
				}
				else if(right.data >= d.data) {
					d.next = right;
					left.next = d;
					return head;
				} 					
			}
			t = t.next;
		}
		return head;
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
		
		printsll(head);
		Node t = new Node(2);
		head = insertInSortedSLL(head, t);
		System.out.println();
		printsll(head);
		head = swapTailAndHead(head);
		System.out.println();
		printsll(head);

	}

}