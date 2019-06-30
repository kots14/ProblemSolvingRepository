import java.io.*;
import java.util.*;

public class KLargestSmallestElements {
    public static void klargestsmallestelements(int a[], int K) {
        PriorityQueue<Integer> maxq = new PriorityQueue<Integer>(Collections.reverseOrder()); 
        PriorityQueue<Integer> minq = new PriorityQueue<Integer>();
        for(int i = 0; i < a.length; i++) {
            maxq.add(a[i]);
            minq.add(a[i]);
        }

        System.out.println(K+" maximum elements:");
        for(int i = 0; i < K; i++) {
            System.out.print(maxq.poll()+" ");
        }

        System.out.println("\n"+K+" minimum elements:");
        for(int i = 0; i < K; i++) {
            System.out.print(minq.poll()+" ");
        }
    }
    public static void main(String[] args) {
        int a[] = { 11, 3, 2, 1, 15, 5, 4, 
            45, 88, 96, 50, 45 }; 

        // Size of Min Heap 
        int k = 3; 
        klargestsmallestelements(a, k); 

    }
}