
public class PalindromePartitioning {

	 private static int solve(String str) { 
	        int n = str.length(); 
	  
	        int[][] C = new int[n][n]; //track minimum cuts
	        boolean[][] P = new boolean[n][n]; //track if substring is palindrome or not
	  
	       
	        for (int i = 0; i < n; i++) { 
	            P[i][i] = true; 
	            C[i][i] = 0; 
	        } 
	  
	        for (int L = 2; L <= n; L++) { 
	            for (int i = 0; i < n - L + 1; i++) { 
	                int j = i + L - 1; 
	                if (L == 2) 
	                    P[i][j] = (str.charAt(i) == str.charAt(j)); 
	                else
	                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1]; 
	  
	                
	                if (P[i][j]) 
	                    C[i][j] = 0; 
	                else { 
	                    
	                    C[i][j] = Integer.MAX_VALUE; 
	                    for (int k = i; k <= j - 1; k++) 
	                        C[i][j] = Integer.min(C[i][j], 
	                                              C[i][k] + C[k + 1][j] + 1); 
	                } 
	            } 
	        } 
	  
	        return C[0][n - 1]; 
	    } 
	  
	    // Driver program to test above function 
	    public static void main(String args[]) { 
	        String s = "ababbbabbababa"; 
	        System.out.println(solve(s)); 
	    } 

}
