import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://www.geeksforgeeks.org/majority-element/
public class MajorityElement {
	
	//Time complexity : O(n)
	//Space complexity : O(n)
	private static int solve(int[] a) {
		int output = 0;
		HashMap<Integer, Integer> h = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < a.length; i++) {
			h.put(a[i], h.getOrDefault(a[i], 0) + 1);
		}
		int count = Integer.MIN_VALUE;
		for(Map.Entry<Integer, Integer> me : h.entrySet()) {
			if(count < me.getValue()) {
				count = me.getValue();
				output = me.getKey();
				set.clear();
				set.add(me.getKey());
			} else if(count == me.getValue())
				set.add(me.getKey());
				
		}
		if(set.size() > 1)
			return Integer.MIN_VALUE;
		return output;
	}
	public static void main(String[] args) {
		int a[] = {1, 3, 3, 3,  1, 1, 1, 2}; 
		System.out.println(solve(a));
	}

}
