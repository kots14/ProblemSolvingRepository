import java.util.ArrayList;

// Connected components in undirected graph

public class FindConnectedComponentsInGraph {

	static class Graph {
        int N;
        ArrayList<ArrayList<Integer>> list;
        public Graph(int v) {
            N = v;
            list = new ArrayList<>(v);
            for(int i = 0; i < v; i++)
                list.add(new ArrayList<>());
        }
        public void addEdge(int v1, int v2) {
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
    }
	static void DFS(Graph g, int i, boolean[] visited) {
        visited[i] = true;
        //mark current visited node and print
        System.out.print(i +" ");
        
        ArrayList<Integer> neighbors = g.list.get(i);
        for(Integer x : neighbors)
            if(!visited[x]) DFS(g, x, visited);
    }
    static void printConnectedComponents(Graph g) {
        boolean[] visited = new boolean[g.N];
        for(int i = 0; i < g.N; i++) {
        	if(!visited[i]) {
        		DFS(g, i, visited);
        		System.out.println();
        	}        	
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);  
        g.addEdge(2, 3);  
        g.addEdge(3, 4); 

        printConnectedComponents(g);
    }

}
