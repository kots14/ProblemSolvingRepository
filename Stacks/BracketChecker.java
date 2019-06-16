import java.io.*;
import java.util.*;

//Problem:
//--------
// Check if the given string of brackets is balanced or not
// Input :
//--------
// (){}[]
// ((({{[[]]}})))
// (([))
// ()(){(})
// Output : 
//---------
// true
// true
// false
// false
public class BracketChecker {

	public static void main(String[] args) {
		
		try {
			InputStream inputStream = new DataInputStream(new FileInputStream("problemsolving\\Stacks\\io\\brackets.txt"));
			OutputStream outputStream = new DataOutputStream(new FileOutputStream("problemsolving\\Stacks\\io\\brackets_out.txt"));
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
			Stack<Character> stack = new Stack<>();
			while(T-- > 0) {
				char[] a = in.readLine().toCharArray();
                
                for(char x : a) {
                    
                    if(stack.empty()) {
                       stack.push(x);                        
                    } else {
                        if((stack.peek() == '(' && x == ')')
                            || (stack.peek() == '{' && x == '}')
                            || (stack.peek() == '[' && x == ']'))
                            stack.pop();
                        else
                            stack.push(x);  
                            
                    }
                }

                boolean output = (stack.empty())? true : false;
                out.println(output);
                stack.clear();
				
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
