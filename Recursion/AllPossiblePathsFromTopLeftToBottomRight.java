import java.io.*;
import java.util.*;

// Problem : https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/

public class AllPossiblePathsFromTopLeftToBottomRight {
    static int countPossiblePaths(int n, int m) {
        //base case
        if(m == 1 || n == 1)
            return 1;
        //constraint : from each cell you can either move only to right or down
        return countPossiblePaths(n - 1, m) + countPossiblePaths(n, m - 1);
    }
    public static void main(String[] args) {
        System.out.println(countPossiblePaths(3, 3));
    }
}