//Problem  : https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
public class NthPowerOfNumber {
	/**
	 * Utility function for implementing actual logic
	 * O(N) is time complexity for this
	 * @param N number for whom the power has to be calculated
	 * @param k number to find kth power of N
	 * @param localPower variable to store local recursive output
	 * @return calculated power of the number N
	 */
	/*private static long powUtil(long N, long k, long localPower) {
		if(k == 0) return localPower;
		localPower = localPower * N;
		return powUtil(N, k - 1, localPower);
	}*/
	/**
	 * Utility function for implementing actual logic
	 * O(logN) is time complexity for this
	 * @param N number for whom the power has to be calculated
	 * @param k number to find kth power of N
	 * @param localPower variable to store local recursive output
	 * @return calculated power of the number N
	 */
	private static long powUtil(long N, long k, long localPower) {
		//N^0 = 1
		if(k == 0) return 1;
		
		localPower = powUtil(N, k / 2, localPower);
		if(k % 2 == 0) {
			localPower = localPower * localPower;
		}
		else {
			localPower = N * localPower * localPower;
		}
		
		return localPower;
	}
	/**
	 * Main pow function to be called
	 * @param N number for whom the power has to be calculated
	 * @param k number to find kth power of N
	 * @return calculated power of the number N
	 */
	public static long pow(long N, long k) {
		return powUtil(N, k, 1);
	}
	
	
	public static void main(String[] args) {		
		System.out.println(pow(2, 3) == 8);
		System.out.println(pow(10, 2) == 100);
		System.out.println(pow(17, 2) == 289);
	}

}
