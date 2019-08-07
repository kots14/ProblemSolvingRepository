//Problem : 
//https://www.geeksforgeeks.org/find-optimal-weights-which-can-be-used-to-weigh-all-the-weights-in-the-range-1-x/
//Approach:
//
//One optimal approach is to use weights which are a powers of 3 i.e. {1, 3, 9, 27, 81, 243, …}
//It can be proved through induction that using {1, 3, 9, 27, 81, …, pow(3, n)}, we can balance all the weights from 1 to (pow(3, n + 1) – 1) / 2.
//So, find the values of n such that all the values from 1 to X can be balanced and print the results.
public class OptimalWeights {

	static void findWeights(int X) {  
        int sum = 0;  
  
        // Number of weights required  
        int power = 0;  
        int number = 3; 
          
        // Finding the value of required powers of 3  
        // 1 to (pow(3, n + 1) – 1) / 2.
        while (sum < X) {  
            sum = number - 1;  
            sum /= 2;  
            power++; 
            number *= 3; 
        }  
  
        // Optimal Weights are powers of 3  
        int ans = 1;  
        for (int i = 1; i <= power; i++) {  
            System.out.print(ans + " ");  
            ans = ans * 3;  
        }  
    }  
	public static void main(String[] args) {
		int X = 2;  		  
        findWeights(X);
	}

}
