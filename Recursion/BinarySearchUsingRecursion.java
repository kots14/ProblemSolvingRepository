//Problem : https://www.geeksforgeeks.org/binary-search/
public class BinarySearchUsingRecursion {
	private static int binarySearch(int[] a, int low, int high, int target) {
		if(low >= high) return -1;
		int mid = low + (high - low) / 2;
		if(a[mid] == target)
			return mid;
		else if(a[mid] < target)
			return binarySearch(a, mid + 1, high, target);
		
		return binarySearch(a, low, mid - 1, target);
	}
	public static void main(String[] args) {
		//get sorted array
		int[] a = {1, 3, 4, 5};
		int target = 4;
		int index = binarySearch(a, 0, a.length - 1, target);
		System.out.println("Searching "+target+" in a - " + ((index < 0)? "not found" : "found at "+index));
		
		int[] b = {10, 30, 40, 50, 90, 891, 900, 1000};
		target = 4;
		index = binarySearch(b, 0, b.length - 1, target);
		System.out.println("Searching "+target+" in b - " + ((index < 0)? "not found" : "found at "+index));
	}

}
