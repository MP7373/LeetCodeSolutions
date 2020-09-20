class Solution {

    private int uniquePaths = 0;

    private int[] xs = new int[] { 0, 1, 0, -1 };
    private int[] ys = new int[] { -1, 0, 1, 0 };

    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int y = 0;
        int x = 0;

        boolean[][] visited = new boolean[n][];
        for (int i = 0; i < n; i++) {
            visited[i] = new boolean[m];

            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    y = i;
                    x = j;
                }
            }
        }

        visited[y][x] = true;
        dfs(grid, visited, y, x);

        return uniquePaths;
    }

    private void dfs(int[][] grid,
               boolean[][] visited,
               int y,
               int x) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[y][x] == 2) {
            visited[y][x] = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 0 && !visited[i][j]) {
                        return;
                    }
                }
            }
            visited[y][x] = false;
            uniquePaths++;

            return;
        }



        for (int i = 0; i < 4; i++) {
            int nextY = y + ys[i];
            int nextX = x + xs[i];

            if (0 <= nextY && nextY < n &&
                0 <= nextX && nextX < m &&
               !visited[nextY][nextX] &&
               grid[nextY][nextX] >= 0
            ) {
                visited[nextY][nextX] = true;
                dfs(grid, visited, nextY, nextX);
                visited[nextY][nextX] = false;
            }
        }
    }
}
