import java.io.*;
import java.util.*;
//yet to be completed
public class LongestPathInGraph {
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
        }
    }
    static Integer pathLength = -1;
    //O(V + E)
    static void dfs(Graph g, int i, HashMap<Integer, Boolean> visited) {
        visited.put(i, true);
        pathLength++;
        ArrayList<Integer> neighbors = g.list.get(i);
        for(Integer x : neighbors)
            if(!visited.get(x))
                dfs(g, x, visited);
    }
    
    static int findLongestPath(Graph g) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        Integer output = 0;
       
        
        for(int i = 0; i < g.N; i++) {
            visited.clear();
            for(int x = 0; x < g.N; x++)
                visited.put(x, false);
            
            dfs(g, i, visited);
            System.out.print(pathLength+" ");
            output = Math.max(output, pathLength);
            pathLength = -1;
        }

        return output;
    }
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(7, 4);
        g.addEdge(6, 1);
        g.addEdge(6, 5);
        g.addEdge(3, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 8);

        System.out.println("\n"+findLongestPath(g));

        Graph g1 = new Graph(12);
        g1.addEdge(1, 5);
        g1.addEdge(5, 3);
        g1.addEdge(4, 1);
        g1.addEdge(9, 1);
        g1.addEdge(10, 4);
        g1.addEdge(2, 10);
        g1.addEdge(7, 2);
        g1.addEdge(6, 10);
        g1.addEdge(11, 4);
        g1.addEdge(1, 8);

        System.out.println(findLongestPath(g1));
    }
}