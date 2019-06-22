import javhead.io.*;
import javhead.util.*;

// Given a sorted linked list, delete all nodes that have duplicate numbers, 
// leaving only distinct numbers from the original list.

// For example,
// Given 1.2.3.3.4.4.5, return 1.2.5.
// Given 1.1.1.2.3, return 2.3.

public class RemoveRepatedNodesFromSortedSLL {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
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
            
        Node fakeHead = new Node(0);
        fakeHead.next = head;
        Node prev = fakeHead;
        while (head != null) {
            while (head.next != null && head.data == head.next.data)
                head = head.next;
            
            if (prev.next == head)
                prev = prev.next; 
            else 
                prev.next = head.next;
                
            head = head.next;
        }
        return fakeHead.next;
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