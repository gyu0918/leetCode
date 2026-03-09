// class Solution {
    
//     static int[][] map;
//     static boolean[][] check;
//     static int[] x = {1,-1,0,0};
//     static int[] y = {0,0,1,-1};  
    
//     public int numIslands(char[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         map = new int[m][n];
//         check = new boolean[m][n];
//         return bfs();
//     }
//     public int bfs(){
//         Deque<
//     } 
// }

class Solution {
    static boolean[][] visited;
    static int[] drow = {-1,1,0,0};
    static int[] dcol = {0,0,-1,1};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid,  i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int crow = cur[0];
            int ccol = cur[1];

            for (int i = 0; i < 4; i++) {
                int nrow = crow + drow[i];
                int ncol = ccol + dcol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                    if (grid[nrow][ncol] == '1' && !visited[nrow][ncol]) {
                        visited[nrow][ncol] = true;
                        queue.offer(new int[]{nrow, ncol});
                    }
                }
            }
        }
    }
}