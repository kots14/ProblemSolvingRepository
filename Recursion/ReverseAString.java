//Problem : https://www.geeksforgeeks.org/reverse-a-string-using-recursion/
public class ReverseAString {
	private static String reverseString(String string, StringBuilder stringBuilder) {
		//handling edge cases
		if(string == null || string.isEmpty() || string.length() <= 0)
			return stringBuilder.toString();
		stringBuilder.append(string.charAt(string.length() - 1));
		return reverseString(string.substring(0, string.length() - 1), stringBuilder);
	}
	public static void main(String[] args) {
		System.out.println(reverseString("bac", new StringBuilder()));
		System.out.println(reverseString("", new StringBuilder()));
		System.out.println(reverseString(null, new StringBuilder()));
		System.out.println(reverseString("this doesn't make sense", new StringBuilder()));
	}

}
