import java.io.*;
import java.util.*;

//Problem : https://www.geeksforgeeks.org/queue-using-stacks/

public class QueueUsingStack {
    static class Queue<T> {
        private Stack<T> a = null;
        private Stack<T> b = null;
        private T front = null;
        private T rear = null;
        public Queue() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public T getFront() {
            return this.front;
        }

        public T getRear() {
            return this.rear;
        }

        public void enqueue(T element) {
            //pushing all elements in stack a in stack b
            while(!a.empty()) {
                T popped = a.pop();
                b.push(popped);
            }
            a.push(element);
            this.front = element;
            //pushing all elements in stack b from stack a
            while(!b.empty()) {
                T popped = b.pop();
                a.push(popped);
            }
            this.rear = a.peek();
        }

        public T dequeue() {
            T popped = null;
            if(!a.empty()) {
                popped = a.pop();
            }
            return popped;
        }
        public int size() {
            return a.size();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        for(int i = 0 ; i < 10; i++)
            q.enqueue(i);
        System.out.println("q.size(): "+q.size());
        System.out.println("q.getFront(): "+q.getFront());
        System.out.println("q.getRear(): "+q.getRear());
       
        int N = q.size();
        for(int i = 0 ; i < N; i++)
            System.out.println(" "+q.dequeue());
        
        System.out.println("q.size(): "+q.size());
    }
}