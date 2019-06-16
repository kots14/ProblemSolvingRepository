import java.io.*;
import java.util.*;

// Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".

// changePi("xpix") → "x3.14x"
// changePi("pipi") → "3.143.14"
// changePi("pip") → "3.14p"

public class ChangePi {
    public static void main(String[] args) {
        try {
			InputStream inputStream = new DataInputStream(new FileInputStream("problemsolving\\Recursion\\io\\ChangePi.txt"));
			OutputStream outputStream = new DataOutputStream(new FileOutputStream("problemsolving\\Recursion\\io\\ChangePi_out.txt"));
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
            while(T-- > 0){
                String x = in.readLine();
                out.println(changePi(x));
            }
        }
        private String changePi(String s) {
            StringBuilder sb = new StringBuilder(s);
            return changePi(sb, 0).toString();
        }
        
        private StringBuilder changePi(StringBuilder sb, int i) {
        
            if (i + "pi".length() <= sb.length()) {
        
                if (sb.subSequence(i, i + "pi".length()).equals("pi")) {
                    //replace pi with 3.14
                    sb.replace(i, i + "pi".length(), "3.14");
                    return changePi(sb, i + "3.14".length());
                }
        
                return changePi(sb, i + 1);
        
            }
            return sb;
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


