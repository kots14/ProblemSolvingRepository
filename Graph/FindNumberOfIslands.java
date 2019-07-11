// Problem : https://www.geeksforgeeks.org/find-number-of-islands/
public class FindNumberOfIslands {
    static boolean isSafe(int[][] M, int ROW, int COL, int row, 
                       int col, boolean[][] visited) { 
        return (row >= 0) 
        && (row < ROW) 
        && (col >= 0) 
        && (col < COL) 
        && (M[row][col] == 1 && !visited[row][col]); 
    } 
    static void DFS(int[][] g, int ROW, int COL, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int[] rowNumbers = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; 
        int[] colNumbers = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 
        
        for (int k = 0; k < 8; ++k) 
            if (isSafe(g, ROW, COL, i + rowNumbers[k], j + colNumbers[k], visited)) 
                DFS(g, ROW, COL, i + rowNumbers[k], j + colNumbers[k], visited);
    }
    static int findNumberOfIslands(int[][] M, int ROW, int COL) {
        boolean[][] visited = new boolean[ROW][COL];
        for(int i = 0; i < ROW; i++)
            for(int j = 0; j < COL; j++)
                visited[i][j] = false; 

        int count = 0; 
        for (int i = 0; i < ROW; ++i) 
            for (int j = 0; j < COL; ++j) 
                if (M[i][j] == 1 && !visited[i][j]) { 
                    DFS(M, ROW, COL, i, j, visited); 
                    ++count; 
                } 
    
        return count;         
    }
    public static void main(String[] args) {
        int[][] m = { { 1, 1, 0, 0, 0 }, 
                     { 0, 1, 0, 0, 1 }, 
                     { 1, 0, 0, 1, 1 }, 
                     { 0, 0, 0, 0, 0 }, 
                     { 1, 0, 1, 0, 1 } }; 

        System.out.println(findNumberOfIslands(m, m.length, m.length));             
    }
}