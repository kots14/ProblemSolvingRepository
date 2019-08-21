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

/*
Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
Examples :
Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output: 6  (j = 7, i = 1)

Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
Output: 8 ( j = 8, i = 0)*/

public class W1_5 {

	public static void main(String[] args) {
		
		try {
			InputStream inputStream = new DataInputStream(new FileInputStream("..\\problemsolvingrepository\\Arrays\\io\\W1_5.txt"));
			//OutputStream outputStream = new DataOutputStream(new FileOutputStream("problemsolvingrepository\\Arrays\\io\\W1_5_out.txt"));
			OutputStream outputStream = System.out;
			InputReader in = new InputReader(inputStream);
	        PrintWriter out = new PrintWriter(outputStream);
	        new Solver().solve( in, out);
	        out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	static class Solver {
		public void solve( InputReader in, PrintWriter out) {
			int T = Integer.parseInt(in.readLine());
			
			while(T-- > 0) {
				int N = Integer.parseInt(in.readLine());
				int[] a = new int[N];
				String x[] = in.readLine().split(" ");
				for(int i = 0 ; i < N ; i++) {
					a[i] = Integer.parseInt(x[i]);
				}
				
				//setting two index pointers for the array
				
				int output = Integer.MIN_VALUE;
				int[] aleft = new int[N];
				int[] aright = new int[N];
				
				aleft[0] = a[0];
				aright[N - 1] = a[N-1];
				for(int i = 1; i < N; i++) {
					aleft[i] = Math.min(aleft[i-1] , a[i]);
				}
				for(int i = N - 2; i > -1 ; i--) {
					aright[i] = Math.max(aright[i + 1] , a[i]);
				}
				int left = 0;
				int right = 0;
				while(left < N && right < N) {
					//out.println(right - left);
					if(aright[right] > aleft[left]) {
						output = Math.max((right - left), output);
						right++;
					} else
						left++;						
				}
				
				out.println(output);
			}
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
