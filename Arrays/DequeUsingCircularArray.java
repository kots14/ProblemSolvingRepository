import java.io.*;
import java.util.*;

//Problem : https://www.geeksforgeeks.org/implementation-deque-using-circular-array/

public class DequeUsingCircularArray {
    static class Deque<T> {
        Object[] a = null;
        int front = Integer.MIN_VALUE;
        int rear = Integer.MAX_VALUE;
        int DEFAULT_SIZE = 20;
        public Deque(){
            a = new Object[DEFAULT_SIZE];
            front = -1;
            rear = 0;
        }
        public Deque(int size) {
            a = new Object[size];
            front = -1;
            rear = 0;
        }
        public void insertFront(T key) throws Exception {
            if(isFull())
                throw new Exception("Deque overflow");

            //empty state
            if(front == -1)
                front = rear = 0;
            else 
                front = ( front == 0 )? a.length - 1 : front - 1;
           
            a[front] = key;
        }
        public void insertRear(T key) throws Exception {
            if(isFull())
                throw new Exception("Deque overflow");

            if(front == -1)
                front = rear = 0;
            else 
                rear = (rear == a.length - 1)? 0 : rear + 1;
           

            a[rear] = key;
        }
        public void deleteFront() throws Exception{
            if (isEmpty())
                throw new Exception("Deque Underflow");
            
    
            if (front == rear) { 
                front = rear = -1; 
            } else {
                front =  (front == a.length - 1)? 0 : front + 1;
            } 
        }
        public void deleteRear() throws Exception {
            if (isEmpty()) 
                throw new Exception("Deque Underflow");
    
            if (front == rear) { 
                front = rear = -1; 
            } 
            else
                rear = (rear == 0)? a.length - 1 : rear - 1; 
        }
        public T getFront() {
            T output = null;
            if(!isEmpty())
                output = (T) a[front];
            return output;
        }
        public T getRear() {
            T output = null;
            if(!isEmpty())
                output = (T) a[rear];
            return output;
        }
        
        public boolean isFull() {
            return((front == 0 && rear == a.length - 1) || (front == rear + 1));
        }
        public boolean isEmpty() {
            return (front == -1);
        }
    }
    public static void main(String[] args) throws Exception {
        Deque<Integer> d = new Deque<>();
        d.insertRear(10);
        d.insertRear(11);
        System.out.println("Element at rear : " + d.getRear() +", front : " + d.getFront());
        d.insertFront(100);
        d.insertFront(101);
        System.out.println("Element at rear : " + d.getRear() +", front : " + d.getFront());
        d.deleteFront();
        d.deleteRear();
        System.out.println("Element at rear : " + d.getRear() +", front : " + d.getFront());

    }
}