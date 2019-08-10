import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;


public class PrintLongestCommonSubsequence {

	public static void main(String[] args) {
		try {
			InputStream i1Stream = new DataInputStream(new FileInputStream("..\\problemsolvingrepository\\DynamicProgramming\\io\\lcs1.txt"));
			InputStream i2Stream = new DataInputStream(new FileInputStream("..\\problemsolvingrepository\\DynamicProgramming\\io\\lcs2.txt"));
			/*OutputStream outputStream = new DataOutputStream(new FileOutputStream("..\\problemsolvingrepository\\DynamicProgramming\\io\\lcs.out.txt"));
			InputStream i1Stream = System.in;
			InputStream i2Stream = System.in;*/
			OutputStream outputStream = System.out;
			InputReader i1 = new InputReader(i1Stream);
			InputReader i2 = new InputReader(i2Stream);
	        PrintWriter out = new PrintWriter(outputStream);
	        new Solver().solve(i1, i2, out);
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	static class Solver {
		private void printCommon(int[][] L, String X, String Y, int m, int n, PrintWriter out) {
			int index = L[m][n];
			char[] sequence = new char[index];

			int i = m, j = n;
			while (i > 0 && j > 0) {

	            // If current character in X[] and Y are same, then 
	            // current character is part of LCS 
	            if (X.charAt(i-1) == Y.charAt(j-1)) { 
	                sequence[index - 1] = X.charAt(i - 1);  
	                
	                i--;  
	                j--;  
	                index--;      
	            } 
	   
	            // If not same, then find the larger of two and 
	            // go in the direction of larger value 
	            else if (L[i-1][j] > L[i][j-1]) 
	                i--; 
	            else
	                j--; 
			}
			
			// Print the longest common subsequence 
	        for(int k = 0; k < L[m][n]; k++) 
	            out.print(sequence[k]); 
		}
		private int[][] compute(String X, String Y, int m, int n, PrintWriter out) {
			int[][] L = new int[m + 1][n + 1];
			 for (int i=0; i<=m; i++) { 
		      for (int j=0; j<=n; j++) { 
		        if (i == 0 || j == 0) 
		            L[i][j] = 0; 
		        else if (X.charAt(i-1) == Y.charAt(j-1)) 
		            L[i][j] = L[i-1][j-1] + 1; 
		        else
		            L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
		      } 
		    }
			return L;
		}
		public void solve( InputReader i1, InputReader i2, PrintWriter out) {
			String X = i1.readLine();
			String Y = i2.readLine();
			int m = X.length(); 
	        int n = Y.length(); 
	        printCommon(compute(X, Y, m, n, out), X, Y, m, n, out); 
		}
	}
	static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

    }

}
