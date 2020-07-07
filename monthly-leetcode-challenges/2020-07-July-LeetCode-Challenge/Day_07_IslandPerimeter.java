class Solution {
    private int perimiter;
    private boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        visited = new boolean[grid.length][];
        for (var i = 0; i < grid.length; i++) {
            visited[i] = new boolean[grid[0].length];
        }

        perimiter = 0;
        for (var y = 0; y < grid.length; y++) {
            for (var x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 1) {
                    dfs(grid, y, x);
                    return perimiter;
                }
            }
        }

        return perimiter;
    }

    private void dfs(int[][] grid, int y, int x) {
        visited[y][x] = true;

        if ((y > 0 && grid[y - 1][x] == 0) || y == 0) {
            perimiter++;
        }

        if ((x > 0 && grid[y][x - 1] == 0) || x == 0) {
            perimiter++;
        }

        if ((y < grid.length - 1 && grid[y + 1][x] == 0) || y == grid.length - 1) {
            perimiter++;
        }

        if ((x < grid[0].length - 1 && grid[y][x + 1] == 0) || x == grid[0].length - 1) {
            perimiter++;
        }

        if (y > 0 && grid[y - 1][x] == 1 && !visited[y - 1][x]) {
            dfs(grid, y - 1, x);
        }

        if (x > 0 && grid[y][x - 1] == 1 && !visited[y][x - 1]) {
            dfs(grid, y, x - 1);
        }

        if (y < grid.length - 1 && grid[y + 1][x] == 1 && !visited[y + 1][x]) {
            dfs(grid, y + 1, x);
        }

        if (x < grid[0].length - 1 && grid[y][x + 1] == 1 && !visited[y][x + 1]) {
            dfs(grid, y, x + 1);
        }
    }
}
