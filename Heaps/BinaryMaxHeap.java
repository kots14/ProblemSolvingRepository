import java.io.*;
import java.util.*;

//trying to replicate Binary Min heap program for max heap

public class BinaryMaxHeap {
    static class MaxHeap {
        int SIZE = 0;
        int THRESHOLD = 0;
        int a[];
        public MaxHeap(int threshold){
            SIZE = 0;
            THRESHOLD = threshold;
            a = new int[THRESHOLD];
        }

        public void insertKey(int key) throws Exception {
            if(SIZE == THRESHOLD)
                throw new Exception("Heap overflow");
            
            SIZE += 1;    
            a[SIZE - 1] = key;
            int i = SIZE - 1;

            //fixing the max heap property after insertion
            while(i != 0 && a[parent(i)] < a[i]) {
                //swapping contents
                int pai = parent(i);
                int c = a[i] ^ a[pai];
                a[pai] = c ^ a[pai];
                a[i] = c ^ a[i];
 
                i = parent(i);
            }
        }

        public void deleteKey(int i) throws Exception {
            decreaseKey(i, Integer.MIN_VALUE);
            extractMax();
        }

        public void decreaseKey(int i, int newValue) throws Exception {
            if(a[i] < newValue)
                throw new Exception("Invalid operation");
            
            a[i] = newValue;

            while(i != 0 && a[parent(i)] < a[i]) {
                //swapping contents
                int pai = parent(i);
                int c = a[i] ^ a[pai];
                a[pai] = c ^ a[pai];
                a[i] = c ^ a[i];

                i = parent(i);
            }
        }

        private void maxHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int largest = i;
            if(l < SIZE && a[l] > a[i])
                largest = l;
            if(r < SIZE && a[r] > a[i])
                largest = r;
            if(largest != i) {
                 //swapping contents
                int c = a[i] ^ a[largest];
                a[largest] = c ^ a[largest];
                a[i] = c ^ a[i];
                maxHeapify(largest); 
            }
        }

        private int parent(int i) { return (i - 1) / 2; }
        private int left(int i) { return 2 * i + 1 ;}
        private int right(int i) { return 2 * i + 2 ;}
        public int extractMax() { 
            if (SIZE <= 0) 
                return Integer.MIN_VALUE; 
            if (SIZE == 1) { 
                SIZE--; 
                return a[0]; 
            } 
        
            // Store the minimum value, and remove it from heap 
            int root = a[0]; 
            a[0] = a[SIZE - 1]; 
            SIZE--; 
            maxHeapify(0); 
        
            return root;
        }
        public int getMax() { return a[0]; }
    }
    public static void main(String[] args) throws Exception {
        MaxHeap h = new MaxHeap(11); 
        h.insertKey(3); 
        h.insertKey(2); 
        h.deleteKey(1); 
        h.insertKey(15); 
        h.insertKey(5); 
        h.insertKey(4); 
        h.insertKey(45); 
        System.out.println(h.extractMax() + " "); 
        System.out.println(h.getMax() + " "); 
        h.decreaseKey(4, 2); 
        System.out.println(h.getMax());
    }
}