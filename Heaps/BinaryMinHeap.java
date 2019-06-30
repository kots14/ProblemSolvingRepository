import java.io.*;
import java.util.*;

//Source : https://www.geeksforgeeks.org/binary-heap/

public class BinaryMinHeap {
    static class MinHeap {
        int SIZE = 0;
        int THRESHOLD = 0;
        int []a;
        public MinHeap(int threshold) {
            SIZE = 0;
            THRESHOLD = threshold;
            a = new int[THRESHOLD];
        }

        public void insertKey(int k) throws Exception {
            if(SIZE == THRESHOLD)
                throw new Exception("Heap overflow");
            
            SIZE += 1;
            a[SIZE - 1] = k;
            int i = SIZE - 1;

            //fixing min heap property if it's violated
            while(i != 0 && a[parent(i)] > a[i]) {
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
            extractMin(); 
        }
        public void decreaseKey(int i, int newValue) throws Exception {
            if(a[i] < newValue)
                throw new Exception("Invalid Operation");
            a[i] = newValue;
            while (i != 0 && a[parent(i)] > a[i]) { 
                //swapping contents
                int pai = parent(i);
                int c = a[i] ^ a[pai];
                a[pai] = c ^ a[pai];
                a[i] = c ^ a[i];

                i = parent(i);
            }
        }
        private void minHeapify(int i) {
            int l = left(i); 
            int r = right(i); 
            int smallest = i; 
            if (l < SIZE && a[l] < a[i]) 
                smallest = l; 
            if (r < SIZE && a[r] < a[smallest]) 
                smallest = r; 
            if (smallest != i) { 
                //swapping contents
                int c = a[i] ^ a[smallest];
                a[smallest] = c ^ a[smallest];
                a[i] = c ^ a[i];
                minHeapify(smallest); 
            } 
        }
        private int parent(int i) { return (i - 1) / 2; }
        private int left(int i) { return 2 * i + 1 ;}
        private int right(int i) { return 2 * i + 2 ;}
        public int extractMin() { 
            if (SIZE <= 0) 
                return Integer.MAX_VALUE; 
            if (SIZE == 1) { 
                SIZE--; 
                return a[0]; 
            } 
        
            // Store the minimum value, and remove it from heap 
            int root = a[0]; 
            a[0] = a[SIZE - 1]; 
            SIZE--; 
            minHeapify(0); 
        
            return root;
        }
        public int getMin() { return a[0]; }
    }

    public static void main(String[] args) throws Exception {
        MinHeap h = new MinHeap(11); 
        h.insertKey(3); 
        h.insertKey(2); 
        h.deleteKey(1); 
        h.insertKey(15); 
        h.insertKey(5); 
        h.insertKey(4); 
        h.insertKey(45); 
        System.out.println(h.extractMin() + " "); 
        System.out.println(h.getMin() + " "); 
        h.decreaseKey(2, 1); 
        System.out.println(h.getMin());
    }
}