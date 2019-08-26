//https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
//https://www.youtube.com/watch?v=prx1psByp7U
public class MatrixChainMultiplication {

	public static void main(String[] args) {
		//4 matrices are given of dimensions 1x2, 2x3, 3x4, 4x3
		int[] a = {1, 2, 3, 4, 3};
		int N = a.length;
		System.out.println(solve(a, 1, N - 1));
		System.out.println(solveDP(a));
	}

	//using recursion
	private static int solve(int[] a, int i, int j) {
		if(i == j)
			return 0;
		int min = Integer.MAX_VALUE;
		for(int k = i ; k < j; k++) {
			int count = 
					solve(a, i, k)
					+ solve(a, k + 1, j)
					+ a[i - 1] * a[k] * a[j];
			min = Math.min(min, count);
		}
		return min;
	}
	//dynamic programming
	//O(N^3)
	private static int solveDP(int[] a) {
		int[][] m = new int[a.length][a.length];
		for(int i = 0; i < a.length; i++)
			m[i][i] = 0;
		for (int L=2; L< a.length; L++) { 
        	for (int i=1; i< a.length - L + 1; i++) { 
            	int j = i + L - 1; 
            	if(j == a.length) continue; 
                m[i][j] = Integer.MAX_VALUE; 
                for (int k=i; k<=j-1; k++) { 
                    int min = m[i][k] + m[k+1][j] + a[i-1] * a[k] * a[j]; 
                    m[i][j] = Math.min(min, m[i][j]); 
                } 
            } 
        } 
  
        return m[1][a.length-1];
		
	}

}
