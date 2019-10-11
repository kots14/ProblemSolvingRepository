import java.util.Stack;

public class Braces {
	private static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for (char c : A.toCharArray()) {
            if (c == ')') {
                char top = stack.peek();
                stack.pop();
                
                if (top == '(') return 1;
                else {
                    int count = 0;
                    while (top != '(') {
                        top = stack.peek();
                        stack.pop();
                        count++;
                    }
                    
                    if (count == 1) return 1;
                }
            }
            else {
                stack.add(c);
            }
        }
        
        return 0;
    }
	public static void main(String[] args) {
		System.out.println(solve("((a + b))"));
		System.out.println(solve("(a + (a + b))"));
	}

}
