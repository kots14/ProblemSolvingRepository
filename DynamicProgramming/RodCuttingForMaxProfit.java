import java.util.ArrayList;

public class RodCuttingForMaxProfit {
    static int cr(int[] p, int n) {
    	
    	int dp[] = new int[n + 1]; 
        dp[0] = 0; 
  
        for (int i = 1; i <= n; i++) { 
            int x = Integer.MIN_VALUE; 
            for (int j = 0; j < i; j++) 
                x = Math.max(x, p[j] + dp[i - j - 1]); 
            dp[i] = x; 
        }  
        
        return dp[n];
    }
    public static void main(String[] args) {     
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20};  
        int n = p.length;
        System.out.println(cr(p, n));
    }
}