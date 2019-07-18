import java.util.*;
public class DeleteGraphNodesOfDegreeK {
    
    static class Graph {
        int N;
        ArrayList<LinkedList<Integer>> list;
        HashMap<Integer, Integer> degree;
        public Graph(int v) {
            N = v;
            list = new ArrayList<>(v);
            degree = new HashMap<>();
            for(int i = 0; i < v; i++)
                list.add(new LinkedList<>());
        }
        public void addEdge(int v1, int v2) {
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        public void setDegree() {
            for(int i = 0; i < N; i++) {
                degree.put(i, list.get(i).size());
            }
        }
    }
    static void dfsDelete(Graph g, int i, HashMap<Integer, Boolean> visited, int K) {
        visited.put(i, true);
        LinkedList<Integer> neighbors = g.list.get(i);
        if(g.degree.get(i) < K) {
            g.degree.put(i, 0);
            for(Integer x : neighbors) {
                if(g.degree.get(x) >= K) {
                    g.degree.put(x, (g.degree.get(x) - 1));
                    visited.put(x, false);
                }
                if(!visited.get(x))
                    dfsDelete(g, x, visited, K);
                
            }            
        }
        
    }
    
    static void deleteNodes(Graph g, int K) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
       
        for(int x = 0; x < g.N; x++)
            visited.put(x, false);
        
        for(int i = 0; i < g.N; i++) {
            if(!visited.get(i))
            dfsDelete(g, i, visited, K);
        }
    }
    static void printGraphAfterKDeletion(Graph g, int K) {      
        for(int v = 0; v < g.N; v++) {
            if(g.degree.get(v) < K)
                continue; 
            System.out.println(v); 
            for(Integer x: g.list.get(v)){ 
                if(g.degree.get(x) < K)
                    continue; 
                System.out.println(" -> "+x); 
            } 
        } 
    }
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 6);
        g.addEdge(3, 4);
        g.addEdge(3, 7);
        g.addEdge(4, 6);
        g.addEdge(4, 7);
        g.addEdge(7, 6);
        g.addEdge(5, 6);
        g.addEdge(5, 8);
        g.addEdge(6, 8);

        g.setDegree();
        deleteNodes(g, 3);
        printGraphAfterKDeletion(g, 3);
    }
}