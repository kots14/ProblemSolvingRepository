import java.util.ArrayList;
import java.util.List;

// Problem : https://www.geeksforgeeks.org/print-subsequences-string/
public class SubsequenceOfString {

	private static void getSubsequences(String string, String temp, List<String> result) {
		if(string.length() == 0) {
			result.add(temp.toString());
			return;
		}
		getSubsequences(string.substring(1), temp + string.charAt(0), result);
		getSubsequences(string.substring(1), temp, result);
	}
	public static void main(String[] args) {
		List<String> result = new ArrayList<>();
		getSubsequences("abc", "", result);
		result.stream().forEach(s -> System.out.println(s));

	}

}
