import java.io.*;
import java.util.*;

// Generate all binary strings without consecutive 1’s
// Given a integer N, print All binary string of size N.

// N = 3  
// O/p : 000 001 010 100 101 

// N  = 4 
// O/p : :0000 0001 0010 0100 0101 1000 1001 1010   

public class BinaryStringsWithoutConsecutiveOnes {
    public static void main(String[] args) {
        try {
			InputStream inputStream = new DataInputStream(new FileInputStream("problemsolving\\Recursion\\io\\BinaryStringsWithoutConsecutiveOnes.txt"));
			OutputStream outputStream = new DataOutputStream(new FileOutputStream("problemsolving\\Recursion\\io\\BinaryStringsWithoutConsecutiveOnes_out.txt"));
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
                int N = Integer.parseInt(in.readLine());
                bswco(in, out, N);
                out.println();
            }
        }

        private void bswco(InputReader in, PrintWriter out, int N) {
            if(N <= 0)
                return;
            char[] a = new char[N];
            a[0] = '1';
            bswco(in,out, N, a, 1);
            a[0] = '0';
            bswco(in,out, N, a, 1);
        }
        private void bswco(InputReader in, PrintWriter out, int N, char[] a, int i) {
            if(i == N) {
                String s = new String(a);
                out.print(s+" ");
                return;
            }
            if(a[i - 1] == '0') {
                a[i] = '0';
                bswco(in, out, N, a, i + 1);
                a[i] = '1';
                bswco(in, out, N, a, i + 1);
            } else if(a[i - 1] == '1') {
                a[i] = '0';
                bswco(in, out, N, a, i + 1);
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