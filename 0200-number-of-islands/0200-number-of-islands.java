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
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        // 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 새로운 섬 발견
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, dx, dy);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int x, int y, int[] dx, int[] dy) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        // 방문 처리
        grid[x][y] = '0';

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 안이고, 육지이면
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                    queue.offer(new int[]{nx, ny});
                    grid[nx][ny] = '0'; // 방문 처리
                }
            }
        }
    }
}