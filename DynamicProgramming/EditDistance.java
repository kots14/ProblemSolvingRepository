//https://www.interviewbit.com/problems/edit-distance/
public class EditDistance {
	static int solve(String A, String B, int m, int n) {
		if(m == 0) return n;
		if(n == 0) return m;
		if(A.charAt(m - 1) == B.charAt(n - 1))
			return solve(A, B, m - 1, n - 1);
		
		return 1 + Math.min(
        		Math.min( 
        				solve(A, B, m, n - 1), // Insert 
                        solve(A, B, m - 1, n)  // Remove 
                    ),  
                    solve(A, B, m - 1, n - 1)  // Replace
                  );  
	}	
	static int solveDP(String A, String B, int m, int n) { 
        int dp[][] = new int[m+1][n+1]; 
       
        for (int i=0; i<=m; i++) { 
            for (int j=0; j<=n; j++) { 
                if (i == 0) 
                    dp[i][j] = j;  
                else if (j == 0) 
                    dp[i][j] = i;  
                else if (A.charAt(i - 1) == B.charAt(j - 1)) 
                    dp[i][j] = dp[i - 1][j - 1]; 
                else
                    dp[i][j] = 1 + Math.min(
                    		Math.min(
                    			dp[i][j - 1], // Insert 
                                dp[i - 1][j]  // Remove 
                            ),  
                            dp[i - 1][j - 1]  // Replace
                          );  
            } 
        } 
   
        return dp[m][n]; 
    } 
	public static void main(String[] args) {
		String a = "Anshuman"; 
        String b = "Antihuman"; 
        System.out.println( solve( a , b , a.length(), b.length()) );
        System.out.println( solveDP( a , b , a.length(), b.length()) );
	}

}