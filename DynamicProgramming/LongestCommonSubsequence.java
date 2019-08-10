//https://www.geeksforgeeks.org/printing-longest-common-subsequence/
public class LongestCommonSubsequence {

	private static int countLcsLength( char[] X, char[] Y, int m, int n ) { 
//	    if (m == 0 || n == 0) 
//	      return 0; 
//	    if (X[m-1] == Y[n-1]) 
//	      return 1 + countLcsLength(X, Y, m-1, n-1); 
//	    else
//	      return Math.max(countLcsLength(X, Y, m, n-1), countLcsLength(X, Y, m-1, n)); 
		
		int L[][] = new int[m+1][n+1]; 
		  
	    /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
	         that L[i][j] contains length of countLcsLength of X[0..i-1] and Y[0..j-1] */
	    for (int i=0; i<=m; i++) { 
	      for (int j=0; j<=n; j++) { 
	        if (i == 0 || j == 0) 
	            L[i][j] = 0; 
	        else if (X[i-1] == Y[j-1]) 
	            L[i][j] = L[i-1][j-1] + 1; 
	        else
	            L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
	      } 
	    } 
	  return L[m][n]; 
	} 
	public static void main(String[] args) {
		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length; 
	  
	    System.out.println("Length of countLcsLength is" + " " + countLcsLength( X, Y, m, n ) ); 
	}

}
