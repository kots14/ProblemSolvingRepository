import java.io.*;
import java.util.*;
public class FindCycleInGraph {
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
    static boolean isDFSCycle(Graph g, int i, boolean[] visited, 
    boolean[] explored) {
        visited[i] = explored[i] = true;
        ArrayList<Integer> neighbors = g.list.get(i);
        for(Integer x : neighbors)
            if(explored[x] || visited[x])
                return true;
            else if(!visited[x])
                return 
                isDFSCycle(g, x, visited, explored);
                
        explored[i] = false;
        return false;
    }
    static boolean isCyclicGraph(Graph g) {
        boolean[] visited = new boolean[g.N];
        boolean[] explored = new boolean[g.N];
    
        //initializing the visited and explored array
        //with false
        for(int i = 0; i < g.N; i++) {
            visited[i] = explored[i] = false;
        }
        
        for(int i = 0; i < g.N; i++) {
            if(isDFSCycle(g, i, visited, explored))
                return true;
        }
        
        return false;
    }
    public static void main(String[] args) {
        Graph g = new Graph(3);
        g.addEdge(0, 1); 
        g.addEdge(0, 2);  
        g.addEdge(2, 1);

        System.out.println(isCyclicGraph(g));

        g = new Graph(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2);
        g.addEdge(2, 3);

        System.out.println(isCyclicGraph(g));
    }
}