
public class DfsWith2dMatrix {
	static void dfs(int[][] a) {
		if(a.length == 0) return;
		boolean[][] visited = new boolean[a.length][a[0].length];
		dfsUtil(a, 0, 0, visited);
	}
	static void dfsUtil(int[][] a, int i, int j, boolean[][] visited) {
		int row = a.length;
		int col = a[0].length;
		
		if(i < 0 || j < 0 || i >= row || j >= col || visited[i][j])
			return;
		
		//once a node or cell is visited in graph, mark as true
		visited[i][j] = true;
		
		System.out.println(a[i][j]);
		
		dfsUtil(a, i - 1, j, visited); //left of i,j
		dfsUtil(a, i + 1, j, visited); //right of i,j
		dfsUtil(a, i, j - 1, visited); //top of i,j
		dfsUtil(a, i, j + 1, visited); //botoom of i,j
	}
	public static void main(String[] args) {
		int[][] a = {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12}
		};
		dfs(a );

	}

}
