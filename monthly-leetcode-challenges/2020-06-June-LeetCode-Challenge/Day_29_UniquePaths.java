class Solution {
  public int uniquePaths(int m, int n) {
      var grid = new int[m][];

      for (var i = 0; i < m; i++) {
          grid[i] = new int[n];
      }

      for (var i = 0; i < n; i++) {
          grid[m - 1][i] = 1;
      }

      for (var i = 0; i < m; i++) {
          grid[i][n - 1] = 1;
      }

      for (var y = m - 2; y >= 0; y--) {
          for (var x = n - 2; x >= 0; x--) {
              grid[y][x] = grid[y + 1][x] + grid[y][x + 1];
          }
      }

      return grid[0][0];
  }
}
