public class FindCycleInAdjacencyMatrix {

	public static void main(String[] args) {
		int[][] graph = 
			{{1,1,0,0,0,0},
			{0,0,1,0,1,0},
			{0,0,0,1,0,0},
			{0,0,0,0,1,1},
			{1,0,0,0,0,0},
			{0,0,0,0,0,0}};
		System.out.println(isCyclicGraph(graph));

	}

	private static boolean isCyclicGraph(int[][] graph) {
		boolean[][] explored = new boolean[graph.length][graph.length];
		boolean[][] visited = new boolean[graph.length][graph.length];
		
		for(int i = 0; i < graph[0].length; i++)
            for(int j = 0; j < graph.length; j++)
                visited[i][j] = false; 
        
		for(int i = 0; i < graph[0].length; i++) 
			for(int j = 0; i < graph.length; j++)
			if(!visited[i][j] && hasCycleDFS(graph, i, j, visited, explored))
				return true;
		
		return false;
	}

	private static boolean hasCycleDFS(int[][] graph, int i, int j, boolean[][] visited, boolean[][] explored) {
		visited[i][j] = explored[i][j] = true;
		if(i > graph[0].length || j > graph.length || visited[i][j] || explored[i][j])
			return true;
		if(!visited[i][j])
			return hasCycleDFS(graph, i - 1, j - 1, visited, explored)
				|| hasCycleDFS(graph, i - 1, j, visited, explored)
				|| hasCycleDFS(graph, i - 1, j + 1, visited, explored)
				|| hasCycleDFS(graph, i, j - 1, visited, explored)
				|| hasCycleDFS(graph, i, j + 1, visited, explored)
				|| hasCycleDFS(graph, i + 1, j - 1, visited, explored)
				|| hasCycleDFS(graph, i + 1, j, visited, explored)
				|| hasCycleDFS(graph, i + 1, j + 1, visited, explored);
		explored[i][j] = false;
		return false;
	}

}
