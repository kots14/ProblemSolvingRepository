//Problem : https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
public class MinJumpsToReachEnd {
	/**
	 * Recursive function to calculate minimum jumps to reach end
	 * @param a	Array input to be checked for minimum jumps
	 * @param low index to store local value to navigate through the array
	 * @return integer value indicating minimum jumps to reach the end
	 */
	private static int minJumps(int[] a, int low) {
		// negative jump value will never reach end
		if(low == a.length - 1 || a[low] <= 0) 
			return 0;
				
		int minimumJumps = Integer.MAX_VALUE;
		
		//for every a[i] check maximum reachability, 
		//a particular a[i] can reach the end, so search space should be
		//restricted within low + a[low]
		for(int i = low + 1; i < a.length && i <= low + a[low]; i++) {
			int jumps = minJumps(a, i);
			//System.out.println(jumps+" "+low);
			
			// negative jump value or zero jump value will never reach end
			if(a[low] > 0) {
				minimumJumps = Math.min(minimumJumps, jumps + 1);
			}
		}
		
		return minimumJumps;			 
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		System.out.println(minJumps(a, 0) == 4);
		System.out.println(minJumps(a, 3) == 2);
		
		int[] b = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(minJumps(b, 0) == 3);
	}

}
