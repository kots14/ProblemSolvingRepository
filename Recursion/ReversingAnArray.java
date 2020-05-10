//Problem : https://j2eedev.org/reversing-an-array-using-recursion-in-java/
public class ReversingAnArray {
	/**
	 * Method to reverse an array using tail recursion
	 * @param a input array that has to be reversed
	 * @param first index pointing to first element in array in a recursive call
	 * @param last index pointing to last element in array in a recursive call
	 */
	private static void arrayReverse(int a[], int first, int last) {
		if(first >= last) return;
		
		//swap first and last index elements
		int temp = a[last];
		a[last] = a[first];
		a[first] = temp;
				
		arrayReverse(a, first + 1, last - 1);
	}
	
	/**
	 * Print an array 
	 * @param a input an array
	 */
	private static void printArray(int a[]) {
		System.out.println();
		for(Integer i : a)
			System.out.print(i+" ");
	}
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 9, 0, 8};
		arrayReverse(a, 0, a.length - 1);
		printArray(a);

	}

}
