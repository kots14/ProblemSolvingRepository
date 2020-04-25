//Problem : https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
/*
 * r - iterator for rows
 * c - iterator for columns
 * row - total number of rows in matrix (2D)
 * col - total number of columns in matrix (2D)
 * 
 * Thresholds of matrix:
 * (0,0)-------------------(0, col)
 *  |                       |
 *  |                       |
 *  |                       |
 *  |                       |
 * (row, 0)-----------------(row, col)
 * 
 * Strategy :
 *  Print outer square, then inner square until all numbers
 *  are included
 * 
 */
public class ArrayFromMatrixInSpiralOrder {
	static void recSpiralPrint(int a[][], int row, int col, int r, int c) {
		if(r >= row || c >= col) return;
		
		// First iteration :
		// Print (0, 0) to (0, col)
		for(int i = c; i < col; i++) {
			System.out.print(a[r][i] + " ");
		}
		r++;
		
		//First iteration :
		//Print (1, col) to (row, col)
		for(int i = r; i < row; i++) {
			System.out.print(a[i][col - 1] + " ");
		}
		col--;
		
		//First iteration :
		//Print (row, col - 1) to (row, 0)
		if(r < row) {
			for(int i = col - 1; i >= c; i--) {
				System.out.print(a[row - 1][i] + " ");
			}
			row--;
		}
		
		//First iteration :
		//Print (row - 1, 0) to (1, 0)
		if(c < col) {
			for(int i = row - 1; i >= r; i--) {
				System.out.print(a[i][c] + " ");
			}
			c++;
		}
		
		recSpiralPrint(a, row, col, r, c);
		
		
	}
	static int[] spiralPrint(int a[][]) {
		int r = 0, c = 0, count = 0;
		int row = a.length;
		int col = a[0].length;
		int out[] = new int[row * col];
		

		while (r < row && c < col) {
			// First iteration :
			// Print (0, 0) to (0, col)
			for (int i = c; i < col; ++i) {
				out[count++] = a[r][i];
			}
			r++;

			//First iteration :
			//Print (1, col) to (row, col)
			for (int i = r; i < row; ++i) {
				out[count++] = a[i][col - 1];
			}
			col--;

			//First iteration :
			//Print (row, col - 1) to (row, 0)
			if (r < row) {
				for (int i = col - 1; i >= c; --i) {
					out[count++] = a[row - 1][i];
				}
				row--;
			}

			//First iteration :
			//Print (row - 1, 0) to (1, 0)
			if (c < col) {
				for (int i = row - 1; i >= r; --i) {
					out[count++] = a[i][c];
				}
				c++;
			}
		}
		return out;
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		int b[] = spiralPrint(a);
		for(int i = 0; i < b.length; i++) System.out.print(b[i] + " ");
		System.out.println();
		recSpiralPrint(a, a.length, a[0].length, 0, 0);
	}
}
