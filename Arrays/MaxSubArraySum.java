import java.io.*;
import java.util.*;

public class MaxSubArraySum {
    public static void main(String args[]) {
        try {
			InputStream inputStream = new DataInputStream(new FileInputStream("problemsolving\\Arrays\\io\\msas.txt"));
			OutputStream outputStream = new DataOutputStream(new FileOutputStream("problemsolving\\Arrays\\io\\msas_out.txt"));
			//OutputStream outputStream = System.out;
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
                
                int max = 0;
                int sum = 0;
                // O(N^3)
                // for(int i = 0 ; i < N ; i++) {
                //     for(int j = i + 1; j < N ;  j++) {
                //         sum = 0;
                //         for(int k = i; k <= j; k++) {
                //             sum += a[k];
                //         }
                //         max = Math.max(sum, max);
                //     }      
                // }

                //O(N^2)
                // for(int i = 0 ; i < N ; i++) {
                //     sum = a[i];
                //     for(j = i + 1; j < N ;  j++) {
                //         sum = Math.max(a[j], sum + a[j]);
                //         max = Math.max(sum, max); 
                //     } 
                        
                // }
                // return max;	

                //O(N) Kadane's algorithm
                for(int i= 0 ; i < N; i++) {
                    sum += a[i];
                    max = Math.max(sum, max);
                    if(sum < 0) sum = 0;
                }

                out.println(max);
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