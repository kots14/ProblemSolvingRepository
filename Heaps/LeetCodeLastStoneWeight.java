//Problem : https://leetcode.com/problems/last-stone-weight/
import java.io.*;
import java.util.*;
public class LeetCodeLastStoneWeight {
    //space : O(n) 
    //Time : O(n)
    public static int lastStoneWeight(int[] stones) {
        if(stones == null)
            return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }
        int x, y, temp;
        while (maxHeap.size() > 1) {
            x = maxHeap.poll();
            y = maxHeap.poll();
            if (x != y) {
                temp = Math.abs(x - y);
                maxHeap.add(temp);
            }
        }
        return (maxHeap.size() == 1 )? maxHeap.poll() : 0;
        
    }
    public static void main(String[] args) {
        int result = lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        System.out.println(result);
    }
}