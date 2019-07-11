import java.io.*;
import java.util.*;

// Problem link:
// https://www.hackerrank.com/challenges/the-power-sum/problem
// Actual submission:
// https://www.hackerrank.com/challenges/the-power-sum/submissions/code/110902982

public class HackerrankThePowerSum {
    static int solve(int X, int N, int i) {
        int temp = (int) Math.pow( i, N);
        if(temp > X)
            return 0;
        else if(temp == X)
            return 1;
        return solve(X, N, (i + 1)) + solve(X - temp, N, (i + 1));
    }
    static int powerSum(int X, int N) {
        return solve(X, N, 1);        

    }

    public static void main(String[] args) {
                try {
			InputStream inputStream = new DataInputStream(new FileInputStream("problemsolving\\Recursion\\io\\HackerrankThePowerSum.txt"));
			OutputStream outputStream = new DataOutputStream(new FileOutputStream("problemsolving\\Recursion\\io\\HackerrankThePowerSum_out.txt"));
			//OutputStream outputStream = System.out;
			InputReader in = new InputReader(inputStream);
            PrintWriter out = new PrintWriter(outputStream);
            int X = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
	        int result = powerSum(X, N);
            out.println(result);
	        out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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