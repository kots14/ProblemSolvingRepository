import java.io.*;
import java.util.*;



public class W3_1 {

	public static void main(String[] args) {
		try {
			//InputStream inputStream = new DataInputStream(new FileInputStream("problemsolving\\Recursion\\io\\W3_1.txt"));
			OutputStream outputStream = new DataOutputStream(new FileOutputStream("problemsolving\\Recursion\\io\\W3_1_out.txt"));
			InputStream inputStream = System.in;
			//OutputStream outputStream = System.out;
			InputReader in = new InputReader(inputStream);
	        PrintWriter out = new PrintWriter(outputStream);
	        new Solver().solve( in, out);
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	static class Solver {
		public void solve( InputReader in, PrintWriter out) {
				
				
				reverse(out, 6);
				out.flush();
				out.println();
				mirror(out, 6);
				out.flush();
				out.println();
				mirrorRefactored(out, 1, 6);
				out.flush();
				out.println();
				reverseMirror(out, 16, 5);
				out.flush();
				out.println();
				reverseMirror(out, 10, 5);
				out.flush();
				out.println();
				out.println(palindromeChecker(101, 101, 0));
				out.flush();
				out.println(palindromeChecker(1011, 1011, 0));
			
		}
		
		
		private void reverse(PrintWriter out, int N) {
			if(N == 0)
				return;

			out.print(N+" ");
			reverse(out, N-1);
		}
		private void straight(PrintWriter out, int start, int N) {
			if(start > N )
				return;
			else
				out.print(start + " ");
			straight(out, start + 1, N);
		}
		private void mirror(PrintWriter out, int N) {
			straight(out, 1, N);
			reverse(out, N);
		}
		
		private void mirrorRefactored(PrintWriter out, int start, int N) {
			if(start > N)
				return;
			
			out.print(start + " " );
			mirrorRefactored(out, start + 1, N);
			out.print(start + " ");
			
		}
		private void reverseMirror(PrintWriter out, int N, int delta) {
			if(delta <= 0)
				return;
			if(N <= 0) {
				out.print(N+" ");
				return;
			}
			out.print(N+" ");
			reverseMirror(out, N-delta, delta);
			out.print(N+" ");
		}
		private boolean palindromeChecker(int N, int n, int temp) {
			if(temp == N)
				return true;
			if(n == 0)
				return false;
			temp = ( temp * 10) + (n % 10);
			
			return false || palindromeChecker(N, n/10, temp);
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