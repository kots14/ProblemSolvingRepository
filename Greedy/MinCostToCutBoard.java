import java.util.Arrays;
import java.util.Collections;

//Problem : 
//https://www.geeksforgeeks.org/minimum-cost-cut-board-squares/
public class MinCostToCutBoard {
	private static Integer minCost(Integer[] x, Integer[] y, int m, int n) {
		Arrays.sort(x, Collections.reverseOrder());
		Arrays.sort(y, Collections.reverseOrder());
		
		int result = 0;
		int i = 0, j = 0, horizontal = 1, vertical = 1;
		while(i < m && j < n) {
			if(x[i] > y[j]) {
				result += x[i] * vertical; 
				i++;
				horizontal++;
			} else {
				result += y[j] * horizontal;
				j++;
				vertical++;
			}
		}
		
		int tempResult = 0;
		
		//if still i < m
		for(;i < m; i++) {
			tempResult += x[i];
		}
		result += tempResult * vertical;
		//if still j < n
		for(tempResult = 0;j < n; j++) {
			tempResult += y[j];
		}
		result += tempResult * horizontal;
		
		return result;
	}
	public static void main(String[] args) {
		Integer[] x = {2, 1, 3, 1, 4};
		Integer[] y = {4, 1, 2};
		System.out.println(minCost(x, y, x.length, y.length));
	}

}
