import java.io.*;
import java.util.*;

// Given a sorted linked list, delete all duplicates such that each element appear only once.

// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

public class RemoveDuplicatesFromSortedSLL {
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

    static Node removeDuplicatesFromSortedSLL(Node head) {
        if(head == null || head.next == null)
            return head;
        Node t = head;
        while(t.next != null) {
            if(t.data == t.next.data)
                t.next = t.next.next;
            else
                t = t.next;
        }

        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(1);        
        Node temp = head.next = new Node(1);
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(4);
        temp = temp.next;


        printlnsll(head);
        head = removeDuplicatesFromSortedSLL(head);
        printlnsll(head);
    }
}