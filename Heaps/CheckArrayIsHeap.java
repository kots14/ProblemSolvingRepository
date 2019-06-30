import java.io.*;
import java.util.*;

//Problem : https://www.geeksforgeeks.org/how-to-check-if-a-given-array-represents-a-binary-heap/

public class CheckArrayIsHeap {
    private static boolean isHeapRecursive(int a[], int n, int i) {
        //for leaf node return true
        if(i > (n - 2) / 2)
            return true;
   
        //checking if left child is greater than a[i]
        if(a[i] < a[2 * i + 1])
            return false;

        //checking if right child is greater than a[i]    
        if((2*i + 2) < n && a[i] < a[2 * i + 2])
            return false;

        return (isHeapRecursive(a, n, 2 * i + 1) && isHeapRecursive(a, n, 2 * i + 2));
    }

    private static boolean isHeapIterative(int a[], int n) {
        int i = 0;
        //while i reaching the leaf node
        while(i <= (n - 2) / 2) {
            //checking if left child is greater than a[i]
            if(a[i] < a[2 * i + 1])
                return false;

            //checking if right child is greater than a[i]    
            if((2*i + 2) < n && a[i] < a[2 * i + 2])
                return false;
            i += 1;    
        }

        return true;
    }
    public static void main(String[] args) {
        int a[] = {90, 15, 10, 7, 12, 2, 7, 3}; 
        boolean output = isHeapIterative(a, a.length); 
        System.out.printf("isHeapIterative = %s", output);
        output = isHeapRecursive(a, a.length, 0); 
        System.out.printf("\nisHeapRecursive = %s", output);
    }
}