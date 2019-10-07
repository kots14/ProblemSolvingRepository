import java.util.ArrayList;
import java.util.Stack;

//https://www.spoj.com/problems/STPAR/
public class STPAR {

	private static boolean isSorted(ArrayList<Integer> a) {
		boolean output = true;
		for(int i = 0; i < a.size() - 1; i++) {
			output = (a.get(i + 1) > a.get(i)) && output;
		}
		return output;
	}
	private static void solve(int a[], int n) {
		Stack<Integer> s = new Stack<>();
		ArrayList<Integer> output = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if(i < n - 1)
				if(s.empty() || (s.peek() > a[i] && a[i] > a[i + 1]) ) {
					s.push(a[i]);
					continue;
				}
			
			output.add(a[i]);
			
		}
		
		while(!s.empty()) {
			output.add(s.pop());
		}
				
		System.out.println(isSorted(output)? "yes" : "no");
	}
	public static void main(String[] args) {
		int[] a = {5, 1, 2, 4, 3 };
		solve(a, a.length);
		int[] b = {4, 1, 5, 3, 2};
		solve(b, b.length);
	}

}
