//http://codeforces.com/contest/5/problem/C
public class LongestRegularBracketSequence {
	private static final int MOD = 1000000;
	private static void solve(String s, int n) {
		int dp[][] = new int[n][n]; 
	      
		  
	    // Considering all balanced substrings
	    for (int i = 0; i < n - 1; i++) 
	        if (s.charAt(i) == '(' &&   
	                s.charAt(i + 1)    == ')') 
	            dp[i][i + 1] = 1; 
	  
	    // Considering all other substrings 
	    for (int l = 2; l < n; l++) { 
	        for (int i = 0, j = l; j < n; i++, j++) { 
	            if (s.charAt(i) == '(' &&  
	                      s.charAt(j) == ')') 
	                dp[i][j] = 1 + dp[i + 1][j - 1]; 
	  
	            for (int k = i; k < j; k++)  
	                dp[i][j] = Math.max(dp[i][j], 
	                        dp[i][k] + dp[k + 1][j]) % MOD;      
	                              
	        } 
	    } 
	    int numOfSubStr = 0;
	    for(int i = 0; i < n; i++) {
	    	for(int j = 0; j < n; j++) {
	    		if(dp[i][j] > 0 && dp[i][j] == dp[0][n - 1])
	    			numOfSubStr++;
	    	}
	    }
	    System.out.println(dp[0][n - 1]+" "+((numOfSubStr == 0)? 1 : numOfSubStr));
	}
	public static void main(String[] args) {
		String s = "))(";
		solve(s, s.length());
		s = ")((())))(()())";
		solve(s, s.length()); 
	}

}
