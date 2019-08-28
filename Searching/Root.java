
public class Root {
	private static double power(double x, int n) {
		if(x == 0)
			return 0;
		double output = 1.0;
		for(int i = 0; i < n; i++) {
			output = output * x;
		}
		return output;
	}
	private static double root(int x, int n) {
		if(x == 0)
			return 0.0;
		double low = 0.0;
		double high = Math.max(1.0, (double)x);
		double approxRoot = 0.0;
		double error = 0.001;
		while(low < high) {			
			approxRoot = (low + high) / 2;
			if(power(approxRoot, n) < x)
				low = approxRoot + error;
			else if(power(approxRoot, n) > x)
				high = approxRoot - error;
			else
				break;
			
		}
		return approxRoot;
	}
	public static void main(String[] args) {
		System.out.println(root(4,2));
		System.out.println(root(3,2));
		System.out.println(root(5,2));
		System.out.println(root(8,3));
		System.out.println(root(25,2));
	}

}
