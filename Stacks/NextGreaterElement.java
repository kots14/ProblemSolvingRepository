import java.io.*;
import java.util.*;

//Problem:
//--------
// Check if the given string of brackets is balanced or not
// Input :
//--------
// 23 45 12 11 80
// 23 80 45 12 11 14
// Output : 
//---------
// 23->45
// 11->80
// 12->80
// 45->80
// 80->-1
//
// 23->80
// 11->14
// 12->14
// 14->-1
// 45->-1
// 80->-1
public class NextGreaterElement {

	public static void main(String[] args) {
		
		try {
			InputStream inputStream = new DataInputStream(new FileInputStream("problemsolving\\Stacks\\io\\nextgreaterelement.txt"));
			OutputStream outputStream = new DataOutputStream(new FileOutputStream("problemsolving\\Stacks\\io\\nextgreaterelement_out.txt"));
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
			Stack<Integer> stack = new Stack<>();
			while(T-- > 0) {
                int N = Integer.parseInt(in.readLine());
                String[] s = in.readLine().split(" ");
                int[] a = new int[N];
                for(int i = 0; i < N; i++) {
                    a[i] = Integer.parseInt(s[i]);
                }
                stack.push(a[0]);
                for(int i = 1; i < N; i++) {
                   while(!stack.empty() && a[i] > stack.peek()) {
                        out.println(stack.peek()+"->"+a[i]);
                        stack.pop();
                    }
                    stack.push(a[i]);
                    
                }
                
                while(!stack.empty()) {
                    out.println(stack.peek()+"->-1");
                    stack.pop();
                }
                stack.clear();
                out.println();
				
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