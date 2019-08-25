//https://www.interviewbit.com/problems/length-of-longest-subsequence/
public class LengthOfIncreasingDecreasingSubsequence {
	private static int solve(int[] A) {
		int n = A.length;
	    int[] fromLeft = new int[n];
	    int[] fromRight = new int[n];
	    for(int i = 0; i < n; i++){
	     fromLeft[i] = 1;
	     fromRight[i] = 1;
	    }
	    for(int i = 1; i < n; i++){
	        for(int j = 0; j < i; j++){
	            if(A[i] > A[j] && fromLeft[i] < fromLeft[j] + 1)
	             fromLeft[i] = fromLeft[j] + 1;
	        }
	    }
	    for(int i = n - 2; i >= 0; i--){
	        for(int j = n - 1; j > i; j--){
	            if(A[i] > A[j] && fromRight[i] < fromRight[j] + 1)
	             fromRight[i] = fromRight[j] + 1;
	        }
	    }
	    int ans=0;
	    for(int i=0;i<n;i++)
	    	ans=Math.max(ans, fromLeft[i] + fromRight[i] - 1);
	    
	    return ans;
	}
	public static void main(String[] args) {
		int[] a = {1, 11, 2, 10, 4, 5, 2, 1};
		System.out.println(solve(a));
	}

}
