import java.io.*;
import java.util.*;

//Problem : https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

public class MaxOfAllSubarraysOfSizeK {
    public static void maxOfAllSubarraysOfSizeK(int[] a, int K) {
        int max = Integer.MIN_VALUE;
        //O((N - K + 1)K) brute force
        // for(int i = 0 ; i < a.length - K + 1; i++) {
        //     max = a[i];
        //     for(int j = 1; j < K; j++) {
        //         max = Math.max(a[i + j], max);
        //     }
        //     System.out.print(max+" ");
        // }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); 
        int window = 0;
        for(int i = 0 ; i <= a.length; ) {
            //edge case
            if(i == a.length) {
                System.out.print(pq.peek()+" ");
                pq.clear();
                break;
            }

            if(window == K) {
                window = 0;
                System.out.print(pq.peek()+" "); //printing max element from the priority queue
                pq.clear();
                i = i - K + 1;
            } else { 
                pq.add(a[i]);
                ++window;
                ++i;
            }
        }
    }
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20 }; 
        int K = 4; 
        maxOfAllSubarraysOfSizeK(a, K);
    }
}