//https://codeforces.com/contest/914/problem/C
public class TravellingSalesmanAndSpecialNumbers {
	private static final int MOD = 1000000007;
	private static int dp[] = new int[1005];
	private static long ncr[][] = new long[1005][1005];
	
	private static int ones(int n) {
	  int cnt = 0;
	  while(n > 0) {
		cnt += (n & 1); 
	    n >>= 2;
	  }
	  return cnt;
	}
	
	private static void calcncr() {
	  for(int i = 0; i <= 1000; i++) {
	    ncr[i][0] = 1;
	  }
	  for(int i = 1; i <= 1000; i++) {
	    for(int j = 1; j <= 1000; j++) {
	      ncr[i][j] = (ncr[i-1][j-1] + ncr[i-1][j]) % MOD;
	    }
	  }
	}
	public static void main(String[] args) {
		String n = "111111011";		
		int k = 2;
		calcncr();

		dp[1] = 0;
		for(int i = 2; i <= 1000; i++) {
			dp[i] = dp[ones(i)] + 1;
		}


		if(k == 0){
			System.out.println("1");
			return;
		}

		int nones = 0;
		long ans = 0;
		for(int i = 0; i < n.length(); i++) {
			if(n.charAt(i) == '0')
				continue;
	    
			for(int j = Math.max(nones, 1); j < 1000; j++) {
		      if(dp[j] == k - 1) {
		        ans = (ans + ncr[n.length() - i - 1][j - nones]) % MOD;
		        if(i == 0 && k == 1)
		          ans = (ans + MOD - 1) % MOD;
		      }
		    }
			nones++;
		}

		int cnt = 0;
		for(int i = 0; i < n.length(); i++) 
			if(n.charAt(i) == '1') cnt++;
	  
	  	if(dp[cnt] == k-1)
	  		ans = (ans + 1)	% MOD;
	  
	  	System.out.println(ans);

	}

}
