//https://www.interviewbit.com/problems/stairs/

public class Stairs {

	private static int climbTop(int N) {
		
		if(N < 0) return 0;
		if(N <= 1 )	return 1;
		
		return climbTop(N - 1) + climbTop(N - 2);
	}
	
	private static int climbTopDP(int N) {
		int[] dp = new int[N + 1];
		dp[0] = dp[1] = 1;
		for(int i = 2 ; i < N + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[N];
	}
	public static void main(String[] args) {
		int N = 36;
		System.out.println(climbTop(N));
		System.out.println(climbTopDP(N));
	}

}
