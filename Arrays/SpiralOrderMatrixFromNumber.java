//Problem : https://leetcode.com/problems/spiral-matrix-ii/
// - Small variation to spiral matrix problem
/*
 * 
 * (0,0)-------------------(0, col)
 *  |                       |
 *  |                       |
 *  |                       |
 *  |                       |
 * (row, 0)-----------------(row, col)
 * */
public class SpiralOrderMatrixFromNumber {

	public static void main(String[] args) {
		int b[][] = spiralMatrix(3);
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b.length; j++) {
				System.out.print(b[i][j]+" ");				
			}
			System.out.println();
		}
			
	}
	
	private static int[][] spiralMatrix(int n) {
		if(n == 0) return new int[0][0];
		int row = n, col = n;
		int r = 0, c = 0; //r - row iterator, c - col iterator
		int a[][] = new int[row][col];
		int count = 1;
		while(r < row && c < col) {
			// First iteration :
			// Print (0, 0) to (0, col)
			for(int i = c; i < col; i++) {
				a[r][i] = count;
				count++;
			}
			r++;
			
			for(int i = r; i < row; i++) {
				a[i][col - 1] = count;
				count++;
			}
			col--;
			
			if(r < row) {
				for(int i = col - 1; i >= c; i--) {
					a[row - 1][i] = count;
					count++;
				}
				row--;
			}
			
			if(c < col) {
				for(int i = row - 1; i >= r; i--) {
					a[i][c] = count;
					count++;
				}
				c++;
			}
		}
		return a;
	}

}
