import java.io.*;
import java.util.*;

//Problem : https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
//Constraint : from each cell you can either move only to right or down.

public class PrintAllPossiblePathsOfMatrix {
    //m, n: dimensions of the matrix a
    //i, j: index to track through matrix a
    //path: array to keep track of possible paths irrespective of destination
    //pathIndex: tracker to navigate through the path array
    static void printAllPaths(int[][] a, int m, int n, int i , int j, int[] path, int pathIndex) {
        //edge case
        if(i == m && j == n)
            return;
        if(i == m - 1 || j == n - 1 ) {
            //if nowhere to go, forcefully travel towards bottom right
            if(i == m - 1) {
                //print path and then move right and keep printing the path
                for(int x = 0; x < pathIndex; x++)
                    System.out.print(path[x]+" ");
                for(int x = j; x < n; x++)
                    System.out.print(a[i][x]+" ");
            }

            if(j == n - 1) {
                //print path and then move down towards bottom right
                for(int x = 0; x < pathIndex; x++)
                    System.out.print(path[x]+" ");
                for(int x = i; x < m; x++) 
                    System.out.print(a[x][j]+" ");
            }

            System.out.println();
            return;
        } else {
           path[pathIndex] = a[i][j];
        }
        
        //move right
        printAllPaths(a, m, n, i, j + 1, path, (pathIndex + 1));
        //move down
        printAllPaths(a, m, n, i + 1, j, path, (pathIndex + 1));
    }
    public static void main(String[] args) {
        int a[][]={
            {1,2,3},
            {2,4,5},
            {4,4,5}
        };
        int m = 3;
        int n = 3;
        printAllPaths(a, 3, 3, 0, 0, new int[m + n - 1], 0);
    }
}