//Problem : https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] a = { 2, -5, -2, -4, 3 };// {-2};
		int b = maxProductSubarray(a);

		System.out.print(b);

	}

	private static int maxProductSubarray(int[] a) {
		if (a == null || a.length == 0) {
			return 0;
		}
		int result = a[0];

		int maxProduct = a[0];
		int minProduct = a[0];

		for (int i = 1, temp = 0; i < a.length; i++) {
			temp = maxProduct;

			maxProduct = Math.max(Math.max(maxProduct * a[i], minProduct * a[i]), a[i]);

			minProduct = Math.min(Math.min(temp * a[i], minProduct * a[i]), a[i]);

			result = Math.max(result, maxProduct);
		}
		return result;
	}

}
