import java.io.*;
import java.util.*;

// Problem 
// https://www.hackerrank.com/challenges/recursive-digit-sum/problem
// Submission
// https://www.hackerrank.com/challenges/recursive-digit-sum/submissions/code/109894964

public class HackerrankRecursiveDigitSum {
    public static void main(String args[]) {
        try {
			InputStream inputStream = new DataInputStream(new FileInputStream("problemsolving\\Recursion\\io\\HackerrankRecursiveDigitSum.txt"));
			OutputStream outputStream = new DataOutputStream(new FileOutputStream("problemsolving\\Recursion\\io\\HackerrankRecursiveDigitSum_out.txt"));
			//InputStream inputStream = System.in;
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
        public void solve(InputReader in, PrintWriter out) {
            int T = Integer.parseInt(in.readLine());
            while(T-- > 0) {
                String[] x = in.readLine().split(" ");
                int K = Integer.parseInt(x[1]);
                out.println( superDigit(x[0], K));
            }
        }

        private static int superDigit(String n, int k) {
            if(n.length() == 1)
                return Integer.parseInt(n);       
            long sum = 0;
            for(int i =0; i < n.length(); i++) {
                sum += Character.getNumericValue(n.charAt(i));
            }
            return superDigit(""+(sum*k), 1);
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