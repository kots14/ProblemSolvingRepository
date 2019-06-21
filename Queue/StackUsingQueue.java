import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class StackUsingQueue {
    static class Stack<T> {
        Queue<T> a = null;
        Queue<T> b = null;
        public Stack() {
            a = new LinkedList<>();
            b = new LinkedList<>();
        }
        public void push(T element) {
            while(!a.isEmpty()) {
                T removed = a.remove();
                b.add(removed);
            }
            a.add(element);
            while(!b.isEmpty()) {
                T removed = b.remove();
                a.add(removed);
            }
        }
        public T pop() {
            T output = null;
            if(!a.isEmpty())
                output = a.remove();
            return output;
        }
        public T peek() {
            T output = null;
            if(!a.isEmpty())
                output = a.peek();
            return output;
        }

        public int size() {
            return a.size();
        }
        
        public boolean isEmpty() {
            return a.isEmpty();
        }

        public void clear() {
            a.clear();
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for(int i = 1 ; i < 11 ; i++) {
            s.push(i);
        }

        System.out.println(s.peek());
        
        while(!s.isEmpty()) {
            int removed = s.pop();
            System.out.print(" "+removed);
        }

        System.out.println("\nstack size: "+s.size());
    }
}