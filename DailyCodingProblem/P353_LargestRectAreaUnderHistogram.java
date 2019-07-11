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

        int minLeftHeightSoFar = Integer.MAX_VALUE;
        int minRightHeightSoFar = Integer.MAX_VALUE;  

        for(int i = 0, j = a.length - 1, lc = 0, rc = 0; i < a.length || j > -1; i++, j--){
            int leftBar = a[i];
            int rightBar = a[j];
            lc += 1;
            minLeftHeightSoFar = Math.min(minLeftHeightSoFar, leftBar);
            maxRectAreaFromLeft = Math.max(maxRectAreaFromLeft, lc * minLeftHeightSoFar);
            rc += 1;
            minRightHeightSoFar = Math.min(minRightHeightSoFar, rightBar);
            maxRectAreaFromRight = Math.max(maxRectAreaFromRight, rc * minRightHeightSoFar);
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