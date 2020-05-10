//Problem : https://www.geeksforgeeks.org/convert-a-string-to-an-integer-using-recursion/
public class ConvertStringToInteger {
	/**
	 * Method to convert string to integer using recursion
	 * @param s	String input to convert to integer
	 * @param index used for iteration through recursive calls
	 * @return Integer value of the string input
	 */
	private static int getInteger(final String s, int index) {
		if(index >= s.length() || s.isEmpty() || s == null) 
			return 0;
		
		int toMultiplyWith = s.charAt(index) - '0';
		
		//Recursive function
		// f(n) = 10 ^ (n - i) * f( i + 1) for i = 0 to n
		return (int)Math.pow(10, s.length() - 1 - index) * toMultiplyWith
				+ getInteger(s, index + 1);
	}
	
	public static void main(String[] args) {
		int x = getInteger("01235", 0);
		System.out.println(x);
		int y = getInteger("1012350", 0);
		System.out.println(y);
	}

}
