// https://www.spoj.com/problems/ADASEQEN/
import java.util.HashMap;
//import java.util.Scanner;

public class ADASEQEN {
	private static int solve(HashMap<Character, Integer> cost, char[] X, char[] Y, int n, int m) {
		
		int L[][] = new int[n + 1][m + 1]; 
		//handling corner cases
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < m + 1; j++)
				if(i == 0 || j == 0)
					L[i][j] = 0;
		}
	    /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
	         that L[i][j] contains length of countLcsLength of X[0..i-1] and Y[0..j-1] */
	    for (int i = 1; i < n + 1; i++) { 
	      for (int j = 1; j < m + 1; j++) { 
	        //adding in cost of each alphabet in order to get the solution
            L[i][j] = (X[i - 1] == Y[j - 1]) ?  
            		L[i - 1][j - 1] + cost.get(X[i - 1]) 
        			: Math.max(L[i - 1][j], L[i][j - 1]); 
	      } 
	    } 
	  return L[m][n];
	}
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		int n = 4; //sc.nextInt();
		int m = 4; //sc.nextInt();
		HashMap<Character, Integer> cost = new HashMap<>();
		for(char i = 'a'; i <= 'z'; i++) {
			int x = 1; //sc.nextInt();
			cost.put(i, x);
		}
		String x = "abcd";//sc.next();
		String y = "dbca";//sc.next();
		System.out.println(solve(cost, x.toCharArray(), y.toCharArray(), n, m));
	}

}
