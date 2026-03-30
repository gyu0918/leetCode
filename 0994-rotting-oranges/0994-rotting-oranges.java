import java.util.*;
import java.io.*;

class Solution {
    static int[][] grid;
    static boolean[][] check;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1}; 
    
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // 처음 썩은 오렌지 전부 큐에 넣기
        // fresh orange 개수 세기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // 처음부터 fresh orange가 없으면 0
        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;   // fresh -> rotten
                        freshCount--;
                        queue.offer(new int[]{nx, ny});
                        rottenThisRound = true;
                    }
                }
            }

            // 이번 레벨에서 실제로 썩은 오렌지가 생겼을 때만 1분 증가
            if (rottenThisRound) {
                minutes++;
            }
        }

        // 아직 fresh orange가 남아있으면 불가능
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        grid = new int[m][n];
        check = new boolean[m][n];
        //표 생성
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                grid[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(orangesRotting(grid));

    }

}
