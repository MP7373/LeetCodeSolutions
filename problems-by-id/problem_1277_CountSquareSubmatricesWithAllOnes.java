class Solution {
  public int countSquares(int[][] matrix) {
      var squares = 0;

      for (var y = 0; y < matrix.length; y++) {
          for (var x = 0; x < matrix[0].length; x++) {
              squares += countSquaresFromPoint(matrix, y, x);
          }
      }

      return squares;
  }

  private int countSquaresFromPoint(int[][] matrix, int y, int x) {
      var squares = 0;

      for (var i = 0; x + i < matrix[0].length && y + i < matrix.length; i++) {
          for (var testY = y; testY <= y + i; testY++) {
              if (testY >= matrix.length || matrix[testY][x + i] != 1) {
                  return squares;
              }
          }

          for (var testX = x; testX <= x + i; testX++) {
              if (testX >= matrix[0].length || matrix[y + i][testX] != 1) {
                  return squares;
              }
          }

          squares++;
      }

      return squares;
  }
}
