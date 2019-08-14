//Problem : https://www.interviewbit.com/problems/seats/
public class InterviewBitSeats {
	final static int MOD = 10000003;
	private static int solveSeats(String s) {
		//O(n^2) solution
		/*int value = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); ++i) {
			value = Math.min(shift(s.toCharArray(), i), value) % MOD;
		}
		return value % MOD;*/
		
		//O(n) solution
		int i = getMedian(s.toCharArray());
		if (i == -1) {
			return 0;
		}
		return shift(s.toCharArray(), i) % MOD;
	}
	
	private static int shift(char[] c, int i) {
		int count = 0;
		int j = 0;
		int k = i; //reference seat for the person to shift
		
		//trying to consolidate all the shifts from left
		while (j < k) {
			if (c[j] == '.') {
				j++;
			}
			//moving reference to left if 'x' is found
			else if (c[k] == 'x') {
				k--;
			}
			//if c[k] = . and c[j] = x
			else {
				//System.out.println("first : j="+j+", k="+k+" c[j]="+c[j]+" c[k]="+c[k]);
				c[k] = c[j];
				c[j] = '.';
				count += k - j;
				j++;
				k--;
			}
		}
		
		//trying to consolidate all the shifts from right
		j = c.length - 1;
		k = i;
		//System.out.println("-----------------");
		while (j > k) {
			if (c[j] == '.') {
				j--;
			}
			//moving reference to right if 'x' if found
			else if (c[k] == 'x') {
				k++;
			}
			//if c[k] = . and c[j] = x
			else {
				//System.out.println("second : j="+j+", k="+k+" c[j]="+c[j]+" c[k]="+c[k]);
				c[k] = c[j];
				c[j] = '.';
				count += j - k; 
				j--;
				k++;
			}
		}
		return count;
	}
	
	private static int getMedian(char[] stc) {
		int output = -1;
		int xCount = 0;
		for (char c : stc) {
			if (c == 'x') {
				xCount++;
			}
		}
		if (xCount == 0) return output;
		xCount = (xCount + 1) / 2;
		int temp = 0;
		for (int i = 0; i < stc.length; ++i) {
			if (stc[i] == 'x') {
				temp++;
				if (temp == xCount) {
					output = i;
					break;
				}
			}
		}
		
		return output;
	}
	public static void main(String[] args) {
		String s = "....x..xx...x..";
		System.out.println(solveSeats(s));

	}

}
