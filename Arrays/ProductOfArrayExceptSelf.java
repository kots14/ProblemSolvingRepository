// Problem : https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/s
public class ProductOfArrayExceptSelf {
	//With two arrays contributing to space complexity
	/*public static int[] productExceptSelf(int[] nums) {
        
        int prefix[] = new int[nums.length];
        int suffix[] = new int[nums.length];
        
        prefix[0] = suffix[nums.length - 1] = 1;
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        for(int i = nums.length - 2; i >= 0; i--) {
        	suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        
        for(int i = 0; i < nums.length; i++) {
        	nums[i] = (prefix[i] * suffix[i]);
        }
        return nums;
    }*/
	
	//with one array contributing to space complexity
	public static int[] productExceptSelf(int[] nums) {
        
        int output[] = new int[nums.length];
        
        output[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        
        int suffix = 1;
        for(int i = nums.length - 1; i > -1; i--) {
        	output[i] = (output[i] * suffix);
        	suffix = suffix * nums[i];
        }
        return output;
    }
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		int[] b = productExceptSelf(a);
		
		for(int i = 0; i < b.length; i++)
			System.out.print(b[i]+" ");
	}

}
