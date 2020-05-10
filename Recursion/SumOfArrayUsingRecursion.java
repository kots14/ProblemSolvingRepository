//Problem : https://www.geeksforgeeks.org/sum-array-elements-using-recursion/
public class SumOfArrayUsingRecursion {
	/**
	 * @param a  array with all the numbers
	 * @param index  index to be used to work with array elements
	 * @param sumSoFar storing local sum for next recursive step
	 */
	private static int arraySum(int[] a, int index, int sumSoFar) {
		//base condition
		if(index == a.length)
			return sumSoFar;
		
		sumSoFar += a[index];
		
		return arraySum(a, index + 1, sumSoFar);
	}
	public static void main(String[] args) {
		int[] test = {1, 3, 4};
		System.out.println(arraySum(test, 0, 0) == 8);
		
		int[] anotherArray = {1, 2, 4, 3, 5, 6, 7, 9, 8};
		System.out.println(arraySum(anotherArray, 0, 0) == 45);
	}

}
