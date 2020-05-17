
public class RatInAMaze {
	private static void explore(int[][] a, int i, int j, String string) {
		if(i == a.length - 1 && j == a[0].length - 1) {
			System.out.println(string);
			return;
		}
		
	}
	public static void main(String[] args) {
		int[][] a = {
			{1, 0, 0, 0},
			{1, 1, 0, 1},
			{1, 1, 0, 0},
			{0, 1, 1, 1}
		}; 

	}

}
