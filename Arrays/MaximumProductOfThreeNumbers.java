// Problem : https://leetcode.com/problems/maximum-product-of-three-numbers/
import java.util.Arrays;
public class MaximumProductOfThreeNumbers {
	//Time complexity : O(NlogN)
	private static int maximumProduct(int[] nums) {
        if(nums == null || nums.length < 3)
            return 0;
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(
            nums[0] * nums[1] * nums[n - 1], 
            nums[n - 1] * nums[n - 2] * nums[n - 3]
        );
    }
	//To add : solution with priority queue
	//To add : solution with O(N) time complexity and O(N) space
	public static void main(String[] args) {
		int[] a= {1, 3, 2, 4};
		System.out.println(maximumProduct(a));

	}

}
