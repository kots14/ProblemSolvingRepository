import java.io.*;
import java.util.*;
// You have access to ranked lists of songs for various users. Each song is represented as an integer, 
// and more preferred songs appear earlier in each list. For example, the list [4, 1, 7] indicates 
// that a user likes song 4 the best, followed by songs 1 and 7.

// Given a set of these ranked lists, interleave them to create a playlist that satisfies everyone's priorities.

// For example, suppose your input is {[1, 7, 3], [2, 1, 6, 7, 9], [3, 9, 5]}. 
// In this case a satisfactory playlist could be [2, 1, 6, 7, 3, 9, 5].

//Possible solution :
//create a common directed graph from the inputs
//Find the longest walk in the directed graph

public class P360_CreatePlaylist {
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
    //O(V + E)
    static void dfs(Graph g, int i, HashMap<Integer, Boolean> visited, ArrayList<Integer> playlist) {
        visited.put(i, true);
        playlist.add(i);
        ArrayList<Integer> neighbors = g.list.get(i);
        for(Integer x : neighbors)
            if(!visited.get(x))
                dfs(g, x, visited, playlist);
    }
    //O(V * (V + E))
    static ArrayList<Integer> getPlaylist(Graph g) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        ArrayList<Integer> playlist = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
       
        
        for(int i = 0; i < g.N; i++) {
            visited.clear();
            for(int x = 0; x < g.N; x++)
                visited.put(x, false);
           
            
            if(output.size() < playlist.size()) {
                output.clear();
                for(Integer k : playlist)
                    output.add(k);   
            }    
            playlist.clear(); 
            
            dfs(g, i, visited, playlist);
        }
        return output;
    }

    static Graph getGraph(int[][] input) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int[] inp : input) {
            for(int x : inp) {
                low = Math.min(x, low);
                high = Math.max(x, high);
            }
            
        }
        
        Graph g = new Graph(high + 1);
        for(int[] inp : input) {
            for(int x = 0; x < inp.length - 1; x++) {
                g.addEdge(inp[x], inp[x + 1]);
            }
            
        }
        return g;
    }
    public static void main(String[] args) {
        int[][] input = {{1, 7, 3}, {2, 1, 6, 7, 9}, {3, 9, 5}};
        ArrayList<Integer> playlist = getPlaylist(getGraph(input));
        
        for(Integer x : playlist)
            System.out.print(x + " ");

        System.out.println();    
        int[][] input2 = {{1, 7, 3, 4}, {4, 2, 1, 6, 7, 9}, {3, 4, 9, 5}};
        ArrayList<Integer> pl = getPlaylist(getGraph(input2));
        
        for(Integer x : pl)
            System.out.print(x + " ");    
    }
}