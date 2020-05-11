public class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      var alreadyFilled = new boolean[image.length][];
      for (var i = 0; i < alreadyFilled.length; i++) {
          alreadyFilled[i] = new boolean[image[0].length];
      }

      floodFill(image, sr, sc, newColor, image[sr][sc], alreadyFilled);

      return image;
  }

  private void floodFill(int[][] image, int sr, int sc, int newColor, int colorToReplace, boolean[][] alreadyFilled) {
      image[sr][sc] = newColor;
      alreadyFilled[sr][sc] = true;

      var rowMod = 0;
      var colMod = 0;
      for (rowMod = -1; rowMod <= 1; rowMod += 2) {
          var newRow = sr + rowMod;
          var newCol = sc + colMod;

          var shouldFill = isInBounds(newRow, newCol, image) &&
              (image[newRow][newCol] == colorToReplace) &&
              (!alreadyFilled[newRow][newCol]);
          if (shouldFill) {
              floodFill(image, newRow, newCol, newColor, colorToReplace, alreadyFilled);
          }
      }

      rowMod = 0;
      for (colMod = -1; colMod <= 1; colMod += 2) {
          var newRow = sr + rowMod;
          var newCol = sc + colMod;

          var shouldFill = isInBounds(newRow, newCol, image) &&
              (image[newRow][newCol] == colorToReplace) &&
              (!alreadyFilled[newRow][newCol]);
          if (shouldFill) {
              floodFill(image, newRow, newCol, newColor, colorToReplace, alreadyFilled);
          }
      }
  }

  private boolean isInBounds(int r, int c, int[][] grid) {
      return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
  }
}
