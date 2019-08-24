import java.util.Arrays;

public class MinimumJumpsToReachEnd {

	public static void main(String[] args) {
		int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(solve(a, 0, a.length - 1));
		System.out.println(solve(a));

	}

	private static int solve(int[] a, int low, int high) {
		int output = Integer.MAX_VALUE;
		if(low == high)
			return 0;
		//when reaching end is not possible
		if(a[low] == 0)
			return output;
		
		for(int i = low + 1; i <= high && i <= low + a[low]; i++ ) {
			int jump = solve(a, i, high);
			if(jump != Integer.MAX_VALUE)
				output = Math.min(output, jump + 1);
		}
		return output;
	}
	
	private static int solve(int[] a) {
		
		int[] dp = new int[a.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		if(a.length == 0)
			return dp[0];
		
		dp[0] = 0;
		
		for(int i = 1; i < a.length; i++) {
			for(int j = 0; j < i; j++) {
				if (i <= j + a[j] && dp[j] != Integer.MAX_VALUE) {
	            	dp[i] = Math.min(dp[i], dp[j] + 1); 
	                break; 
	            }
			}
		}
		return dp[a.length - 1];
	}
}
