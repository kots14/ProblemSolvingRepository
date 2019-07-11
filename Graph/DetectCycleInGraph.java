import java.io.*;
import java.util.*;

// Problem : https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
public class DetectCycleInGraph {
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
    static boolean detectDfsCycle(Graph g, int i, boolean[] visited, boolean[] explored) {
        visited[i] = explored[i] = true;
        for(Integer x : g.list.get(i)) {
            if(!visited[x] && detectDfsCycle(g, x, visited, explored))
                return true;
            else if(explored[x])
                return true;
        }
        explored[i] = false;
        return false;
    }
   
    
    static boolean detectCycleInGraph(Graph g) {
        boolean[] visited = new boolean[g.N];
        boolean[] explored = new boolean[g.N];
        for(int i = 0; i < g.N; i++) {
            visited[i] = explored[i] = false;
        }

        for(int i = 0; i < g.N; i++)
            if(!visited[i] && detectDfsCycle(g, i, visited, explored))
                return true;
        return false;
    }
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(2, 3);

        System.out.println(detectCycleInGraph(g));
    }
}