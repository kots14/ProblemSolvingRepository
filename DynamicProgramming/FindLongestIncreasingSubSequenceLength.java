import java.util.Arrays;

public class FindLongestIncreasingSubSequenceLength {

	private static int solve(int[] a) {
		int N = a.length;
		//checking for sub sequence length so far
		int[] max = new int[N];
		Arrays.fill(max, 1);
		
		int result = 1;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(a[i] > a[j]) {
					max[i] = Math.max(max[i], max[j] + 1);
				}
			}
			result = Math.max(max[i], result);
		}
		
		return result;
	}
	public static void main(String[] args) {
		int[] a = {1, 11, 2, 10, 4, 5, 2, 1};
		System.out.println(solve(a));

	}

}
