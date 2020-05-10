public class FindFactorialWithRecursion {
	private static long factorial(long n) {
		//base condition : 0! = 1
		if(n == 0) return 1;
		return n * factorial(n - 1);
	}
	
	
	public static void main(String[] args) {
		System.out.println(factorial(4));
		System.out.println(factorial(5));
		//this code will work till n = 59
		System.out.println(factorial(59)); 

	}

}
