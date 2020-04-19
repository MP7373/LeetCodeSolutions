class Solution {
  public int minPathSum(int[][] grid) {        
      for (var y = 0; y < grid.length; y++) {
          for (var x = 0; x < grid[0].length; x++) {
              if (y == 0) {
                  if (x > 0) {
                      grid[y][x] += grid[y][x - 1];
                  }
              } else {
                  if (x > 0) {
                      grid[y][x] += Math.min(grid[y][x - 1], grid[y - 1][x]);
                  } else {
                      grid[y][x] += grid[y - 1][x];
                  }
              }
          }
      }
      
      return grid[grid.length - 1][grid[0].length - 1];
  }
}
