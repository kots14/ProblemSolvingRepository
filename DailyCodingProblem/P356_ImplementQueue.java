// Daily Coding Problem: Problem #356 [Hard]
// ------------------------------------------
// This problem was asked by Netflix.

// Implement a queue using a set of fixed-length arrays.

// The queue should support enqueue, dequeue, and get_size operations.
public class P356_ImplementQueue {
    static class Queue<T> {
        int threshold = 0;
        int qsize = 0;
        Object[] a = null;
        int front = Integer.MIN_VALUE;
        int rear = Integer.MIN_VALUE;
        public Queue(int N) {
            threshold = N;
            a = new Object[N];
            front = qsize = 0;
            rear = N - 1;
        }
        public void enqueue(T data) throws Exception {
            if(qsize == threshold)
                throw new Exception("Queue overflow");
            rear = (rear + 1) % threshold;
            a[rear] = data;
            ++qsize;   
            
        }
        public T dequeue() throws Exception {
            if(qsize <= 0)
                throw new Exception("Queue underflow");
            T deleted = (T) a[front];
            a[front] = null;
            front = (front + 1) % threshold;
            --qsize;            
            return deleted;    
        }
        public int get_size() {
            return rear - front + 1;
        }
        // public T getFront() {
        //     return (T)a[front];
        // }
        // public T getRear() {
        //     return (T)a[rear];
        // }
    }
    public static void main(String[] args) throws Exception {
        Queue<Integer> q = new Queue<>(4);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        
        // System.out.println(q.getFront());
        // System.out.println(q.getRear());
        System.out.println(q.dequeue());
        // System.out.println(q.getFront());
        // System.out.println(q.getRear());
        System.out.println(q.get_size());
    }
}