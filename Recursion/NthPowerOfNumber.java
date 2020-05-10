//Problem  : https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
public class NthPowerOfNumber {
	/**
	 * Utility function for implementing actual logic
	 * @param N number for whom the power has to be calculated
	 * @param k number to find kth power of N
	 * @param localPower variable to store local recursive output
	 * @return calculated power of the number N
	 */
	private static long powUtil(long N, long k, long localPower) {
		if(k == 0) return localPower;
		localPower = localPower * N;
		return powUtil(N, k - 1, localPower);
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
		System.out.println(pow(17, 2) == 289);
	}

}
