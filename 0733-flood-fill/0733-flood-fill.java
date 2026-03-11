class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // 시작 색이 바꿀 색이랑 같으면 무한탐색 방지 위해 바로 종료
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int originalColor, int newColor) {
        // 범위 밖이면 종료
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }

        // 시작 색과 다르면 종료
        if (image[x][y] != originalColor) {
            return;
        }

        // 색 변경
        image[x][y] = newColor;

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(image, nx, ny, originalColor, newColor);
        }
    }
}