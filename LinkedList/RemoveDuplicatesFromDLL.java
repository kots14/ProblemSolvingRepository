import java.io.*;
import java.util.*;

//Problem : https://www.geeksforgeeks.org/remove-duplicates-unsorted-doubly-linked-list/

public class RemoveDuplicatesFromDLL {
    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    static void printlnDLL(Node head) {
        Node t = head;
        while( t != null) {
            System.out.print(t.data+" ");
            t = t.next;
        }
        System.out.println();
    }

    static void deleteNode(Node head, Node del) { 
  
        if (head == null || del == null) { 
            return; 
        } 
   
        if (head == del) { 
            head = del.next; 
        } 
  
        if (del.next != null) { 
            del.next.prev = del.prev; 
        } 
  
        if (del.prev != null) { 
            del.prev.next = del.next; 
        } 
  
        del = null;

        return; 
    } 

    static Node addNode(Node head, int d) {
        Node t = head;
        while(t.next != null) t = t.next;
        Node n = new Node(d);
        n.prev = t;
        t.next = n;

        return head;
    }

    static Node removeDuplicatesFromDLL(Node head) {
        HashSet<Integer> h = new HashSet<>();
        Node t = head;
        
        while(t != null) {
            if(h.contains(t.data)) {
               Node next = t.next;
               deleteNode(head, t);
               t = next;
            } else {
                h.add(t.data);
                t = t.next;
            }   
            
        }
        h.clear();
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(4);
        head = addNode(head, 4);
        head = addNode(head, 5);
        head = addNode(head, 6);
        printlnDLL(head);
        head = removeDuplicatesFromDLL(head);
        printlnDLL(head);
    }
}