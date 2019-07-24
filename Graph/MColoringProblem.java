// https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
public class MColoringProblem {
    static int V = 4; 
    static int color[]; 
    static boolean isSafe(int v, int graph[][], int color[], int c)  { 
        for (int i = 0; i < V; i++) 
            if (graph[v][i] == 1 && c == color[i]) 
                return false; 
        return true; 
    } 
    static boolean gc(int graph[][], int m, int color[], int v) { 
        if (v == V) 
            return true; 
        for (int c = 1; c <= m; c++) { 
            if (isSafe(v, graph, color, c)) { 
                color[v] = c; 

                if (gc(graph, m, color, v + 1)) 
                    return true; 
                color[v] = 0; 
            } 
        } 
        return false; 
    } 
    static boolean graphColoring(int graph[][], int m) { 
        //initializing colors with 0
        color = new int[V]; 
        for (int i = 0; i < V; i++) 
            color[i] = 0; 
  
        // Call gc() for vertex 0 
        if (!gc(graph, m, color, 0))  
           return false; 
           
        return true; 
    } 
    static void printSolution(int color[]) { 
        System.out.println("Assigned colors:"); 
        for (int i = 0; i < V; i++) 
            System.out.print(color[i] + " "); 
        System.out.println(); 
    }
    public static void main(String[] args) {
        int g[][] = {{0, 1, 1, 1}, 
                    {1, 0, 1, 0}, 
                    {1, 1, 0, 1}, 
                    {1, 0, 1, 0}}; 
        V = g.length;
        int m = 3; // Number of colors 
        if(graphColoring(g, m))
            printSolution(color);  
    }
}