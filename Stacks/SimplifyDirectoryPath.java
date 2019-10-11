//https://www.interviewbit.com/problems/simplify-directory-path
import java.util.Stack;

public class SimplifyDirectoryPath {
	public static String solve(String A) {
		Stack<String> stack = new Stack<>();
        String[] elements = A.trim().split("/");
        for (String s : elements) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if(!s.isEmpty() && !s.equals(".")) {
                stack.push(s);
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty()) {
            sb.insert(0,stack.pop());
            sb.insert(0, "/");
        }
        
        return sb.length() > 0 ? sb.toString() : "/";
    }
	public static void main(String[] args) {
		System.out.println(solve("/a/./b/../../c/"));
		System.out.println(solve("/home/"));
		System.out.println(solve("/var//etc/"));
	}

}
