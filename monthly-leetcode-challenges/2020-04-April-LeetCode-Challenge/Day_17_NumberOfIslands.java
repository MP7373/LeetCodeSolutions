class Solution {
    public int numIslands(char[][] grid) {
        var visited = new boolean[grid.length][];
        for (var i = 0; i < grid.length; i++) {
            visited[i] = new boolean[grid[0].length];
        }

        var islands = 0;
        for (var y = 0; y < grid.length; y++) {
            for (var x = 0; x < grid[0].length; x++) {
                if (!visited[y][x] && grid[y][x] == '1') {
                    islands++;
                    dfs(y, x, grid, visited);
                }
            }
        }
        
        return islands;
    }
    
    private void dfs(int y, int x, char[][] grid, boolean[][] visited) {
        visited[y][x] = true;
        
        if (y - 1 >= 0 && !visited[y - 1][x] && grid[y - 1][x] == '1') {
            dfs(y - 1, x, grid, visited);
        }
        
        if (x - 1 >= 0 && !visited[y][x - 1] && grid[y][x - 1] == '1') {
            dfs(y, x - 1, grid, visited);
        }
        
        if (y + 1 < grid.length && !visited[y + 1][x] && grid[y + 1][x] == '1') {
            dfs(y + 1, x, grid, visited);
        }
        
        if (x + 1 < grid[0].length && !visited[y][x + 1] && grid[y][x + 1] == '1') {
            dfs(y, x + 1, grid, visited);
        }
    }
}
