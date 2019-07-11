import java.io.*;
import java.util.*;
// Daily Coding Problem: Problem #353 [Medium]
// -------------------------------------------
// This problem was asked by Square.

// You are given a histogram consisting of rectangles of different heights. 
// These heights are represented in an input list, such that [1, 3, 2, 5] corresponds to the following diagram:

//       x
//       x  
//   x   x
//   x x x
// x x x x
// Determine the area of the largest rectangle that can be formed only from the bars of the histogram. 
// For the diagram above, for example, this would be six, representing the 2 x 3 area at the bottom right.
public class P353_LargestRectAreaUnderHistogram {
    static int largestRectangularArea(int[] a) {
        int maxRectAreaFromRight = Integer.MIN_VALUE;
        int maxRectAreaFromLeft = Integer.MIN_VALUE;

        int minHeightSoFar = Integer.MAX_VALUE;
        int lengthSoFar = 0;    
        for(int i = 0; i < a.length; i++) {
            int bar = a[i];
            lengthSoFar += 1;
            minHeightSoFar = Math.min(minHeightSoFar, bar);
            maxRectAreaFromLeft = Math.max(maxRectAreaFromLeft, lengthSoFar * minHeightSoFar);
        } 

        lengthSoFar = 0;
        minHeightSoFar = Integer.MAX_VALUE;
        for(int i = a.length - 1; i >= 0; i--) {
            int bar = a[i];
            lengthSoFar += 1;
            minHeightSoFar = Math.min(minHeightSoFar, bar);
            maxRectAreaFromRight = Math.max(maxRectAreaFromRight, lengthSoFar * minHeightSoFar);
        }    
        return (maxRectAreaFromLeft > maxRectAreaFromRight)? maxRectAreaFromLeft : maxRectAreaFromRight;
    }
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5};
        System.out.println(largestRectangularArea(a));
        int[] b = {1, 3, 5, 5};
        System.out.println(largestRectangularArea(b));
        int[] c = {6, 3, 2, 5};
        System.out.println(largestRectangularArea(c));
    }
}