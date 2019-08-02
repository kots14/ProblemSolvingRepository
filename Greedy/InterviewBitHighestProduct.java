//Problem : Given an array of integers, return the highest product possible by multiplying 3 numbers from the array
//link : https://www.interviewbit.com/problems/highest-product/
import java.io.*;
import java.util.*;
public class InterviewBitHighestProduct {
    //space : O(n)
    //time : O(n) 
    private static Integer solve(ArrayList<Integer> a) {
        Integer result = Integer.MIN_VALUE;
        //taking max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // maybe it takes O(n), ref : https://stackoverflow.com/questions/38324217/java-collection-addall-complexity
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