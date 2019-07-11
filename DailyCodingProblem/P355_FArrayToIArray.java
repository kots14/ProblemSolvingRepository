// Daily Coding Problem: Problem #355 [Hard]
// -----------------------------------------
// You are given an array X of floating-point numbers x1, x2, ... xn. 
// These can be rounded up or down to create a corresponding array Y of integers y1, y2, ... yn.

// Write an algorithm that finds an appropriate Y array with the following properties:

// The rounded sums of both arrays should be equal.
// The absolute pairwise difference between elements is minimized. 
// In other words, |x1- y1| + |x2- y2| + ... + |xn- yn| should be as small as possible.
// For example, suppose your input is [1.3, 2.3, 4.4]. 
// In this case you cannot do better than [1, 2, 5], which has an absolute difference of |1.3 - 1| + |2.3 - 2| + |4.4 - 5| = 1.


public class P355_FArrayToIArray {
    static long[] ftoi(double[] x) {
        long[] y = new long[x.length];
        double sumofabsdiffsofar = 0.0;
        double sumofx = 0.0;
        long sumofy = 0;
            
        for(int i = 0; i < x.length; i++) {
            sumofx += x[i];
            long v1 = Math.round(Math.ceil(x[i]));
            long v2 = Math.round(Math.floor(x[i]));
            
            double s1 = (Math.abs(x[i] - v1)) + sumofabsdiffsofar;
            double s2 = (Math.abs(x[i] - v2)) + sumofabsdiffsofar;

            if(s1 <= s2)
                y[i] = v1;
            else
                y[i] = v2;

            long temp = sumofy + y[i];
            if (Math.round(sumofx) != temp && i == x.length - 1) {
                if(Math.round(sumofx) < temp) {
                    y[i] = Math.min(v1, v2);
                    sumofabsdiffsofar = Math.max(s1, s2);   
                } else {
                    y[i] = Math.max(v1, v2);
                    sumofabsdiffsofar = Math.min(s1, s2);   
                }
            } else 
                sumofabsdiffsofar = Math.min(s1, s2);    
            sumofy += y[i];    
            
        }
        return y;
    }
    public static void main(String[] args) {
        double[] x = {1.3, 2.3, 4.4};
        long[] y = ftoi(x);
        for(long i : y)
            System.out.println(i);    

    }
}