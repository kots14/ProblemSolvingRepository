// Problem : https://www.geeksforgeeks.org/program-check-array-sorted-not-iterative-recursive/
public class CheckIfArrayIsSorted {
	/**
	 * Method to check if the array is sorted or not recursively
	 * @param a array input to be checked
	 * @param low start index of array window for a recursive call
	 * @param high last index of array window for a recursive call
	 * @return boolean value indicating if the array is sorted or not
	 */
	private static boolean isArraySorted(int []a, int low, int high) {
		//base condition
		if(low >= high) return true;
		return (a[low] < a[high]) && isArraySorted(a, low + 1, high - 1);
	}
	public static void main(String[] args) {
		int[] a = {1, 87, 3, 54};
		System.out.println(isArraySorted(a, 0, a.length - 1));
		int[] b = {1, 3, 54};
		System.out.println(isArraySorted(b, 0, b.length - 1));

	}

}
