//https://www.interviewbit.com/problems/longest-arithmetic-progression/
//https://www.geeksforgeeks.org/longest-arithmetic-progression-dp-35/
public class LongestArithmaticProgression {
	static int solve(int set[]) {
		int n = set.length;
        if (n <= 2) return n; 
      
        int dp[][] = new int[n][n]; 
          
        int output = 2; 
       
        for (int i = 0; i < n; i++) 
            dp[i][n - 1] = 2; 
      
        for (int j = n - 2; j >= 1; j--) { 
            // Search for i and k for j 
            int i = j -1 , k = j + 1; 
            while (i >= 0 && k <= n - 1) { 
            	if (set[i] + set[k] < 2 * set[j]) 
            		k++; 
	            else if (set[i] + set[k] > 2 * set[j]) { 
	                dp[i][j] = 2; 
	                i--;  
	            } else { 
	                dp[i][j] = dp[j][k] + 1; 
	                output = Math.max(output, dp[i][j]); 
	                i--; 
	                k++; 
	            } 
            }  
            while (i >= 0) { 
                dp[i][j] = 2; 
                i--; 
            } 
        } 
        return output; 
    }
	public static void main(String[] args) {
		int[] a = {3, 6, 9, 12};
		System.out.println(solve(a));
		int[] b = {9, 4, 7, 2, 10};
		System.out.println(solve(b));
	}

}
