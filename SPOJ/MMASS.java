// https://www.spoj.com/problems/MMASS/
import java.util.Stack;

public class MMASS {
	private static int getMass(char element) {
		switch(element) {
			case 'H': return 1;
			case 'O': return 16;
			case 'C': return 12;
		}
		return 0;
	}
	private static int solve(String s) {
		int output = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				int v = stack.peek();
				stack.pop();
				stack.push(v * (s.charAt(i)-'0'));
			}
			else if(s.charAt(i) == '(') 
				stack.push(-1);
			else if(s.charAt(i) == ')')	{
				int v = 0;
				while(!stack.empty() && stack.peek() != -1)	{
					v += stack.peek();
					stack.pop();
				}
				stack.pop();
				stack.push(v);
			}
			else if(Character.isAlphabetic(s.charAt(i))) 
				stack.push(getMass(s.charAt(i)));
		}
		
		while(!stack.empty()) {
			output += stack.peek();
			stack.pop();
		}
		return output;
	}
	public static void main(String[] args) {
		System.out.println(solve("COOH"));
		System.out.println(solve("CH(CO2H)3"));
		System.out.println(solve("((CH)2(OH2H)(C(H))O)3"));
	}

}
