class Solution {
    
    //bfs
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;

        //8 directions 
        int[][] dir = {
            {-1,-1}, {0,-1}, {1,-1},
            {-1,0},          {1,0},
            {-1,1},  {0,1},  {1,1}
        };

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1}); //row, col, distance

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            if (r == n - 1 && c == n - 1) return d;

            for (int[] dirs : dir){
                int nr = r + dirs[0];
                int nc = c + dirs[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr,nc, d + 1});
                }
            }




        }
        return -1;
    }
}