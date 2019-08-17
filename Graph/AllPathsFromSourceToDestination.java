import java.io.*;
import java.util.*;
//Problem : https://www.geeksforgeeks.org/find-paths-given-source-destination/
public class AllPathsFromSourceToDestination {
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
    static int pathIndex = 0;
    static void dfsPathFinder(Graph g, Integer i, Integer destination, boolean[] visited, ArrayList<Integer> path) {
        visited[i] = true;
       
        //if current node is destination
        if(i.equals(destination)) {
            for(int k = 0; k < path.size(); k++)
                System.out.print(path.get(k)+" ");
            System.out.println();
            visited[i] = false;
            return;    
        }
        ArrayList<Integer> neighbors = g.list.get(i);
        for(Integer x : neighbors) {
            if(!visited[x]) {
                path.add(x); 
                dfsPathFinder(g, x, destination, visited, path);
                path.remove(x); 
            }
        }
        visited[i] = false;
    }

    static void pathFinder(Graph g, int source, int destination) {
        boolean[] visited = new boolean[g.N];
        ArrayList<Integer> path = new ArrayList<>();
        
        Arrays.fill(visited, false);
            
        path.add(source);
        dfsPathFinder(g, source, destination, visited, path);
    }
    public static void main(String[] args) {
        Graph g = new Graph(4); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 3); 
        g.addEdge(2, 0); 
        g.addEdge(2, 1); 
        g.addEdge(1, 3); 

        pathFinder(g, 2, 3);
    }
}