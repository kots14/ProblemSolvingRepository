//Problem : Given an array of integers, return the highest product possible by multiplying 3 numbers from the array
//link : https://www.interviewbit.com/problems/highest-product/
import java.io.*;
import java.util.*;
public class InterviewBitHighestProduct {
    //space : O(n)
    //time : O(1)
    private static Integer solve(ArrayList<Integer> a) {
        Integer result = Integer.MIN_VALUE;
        //taking max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(a);

        //finding first 3 maximum elements out of array
        if(maxHeap.size() > 0) {
            result = 1;
            result = result * maxHeap.poll();
            result = result * maxHeap.poll();
            result = result * maxHeap.poll();
        }

        return result;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(-1);
        a.add(3); 
        a.add(100);
        a.add(70);
        a.add(50);
        System.out.println(solve(a));
    }
}