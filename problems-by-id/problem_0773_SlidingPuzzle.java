import java.util.*;

class Solution {
  public int slidingPuzzle(int[][] board) {
      int rows = board.length;
      int columns = board[0].length;
      
      String correctBoard = Arrays.deepToString(new int[][]{ { 1, 2, 3 }, { 4, 5, 0 } });
      
      Queue<Path> pathsToTry = new LinkedList<>();
      pathsToTry.add(new Path(board, 0));
      
      Set<String> encountered = new HashSet<>();
      encountered.add(Arrays.deepToString(board));

      while (pathsToTry.size() > 0) {
          Path nextPath = pathsToTry.poll();
          
          if (Arrays.deepToString(nextPath.getBoard()).equals(correctBoard)) {
              return nextPath.getSteps();
          }
          
          for (int row = 0; row < rows; row++) {
              for (int column = 0; column < columns; column++) {
                  if (nextPath.getBoard()[row][column] == 0) {
                      if (row - 1 >= 0) {
                          int[][] newBoard = copyBoard(nextPath.getBoard());

                          int temp = newBoard[row - 1][column];
                          newBoard[row - 1][column] = newBoard[row][column];
                          newBoard[row][column] = temp;

                          String encodedBoard = Arrays.deepToString(newBoard);
                          if (!encountered.contains(encodedBoard)) {
                              encountered.add(encodedBoard);
                              pathsToTry.add(new Path(newBoard, nextPath.getSteps() + 1));
                          }
                      }

                      if (row + 1 < rows) {
                          int[][] newBoard = copyBoard(nextPath.getBoard());

                          int temp = newBoard[row + 1][column];
                          newBoard[row + 1][column] = newBoard[row][column];
                          newBoard[row][column] = temp;

                          String encodedBoard = Arrays.deepToString(newBoard);
                          if (!encountered.contains(encodedBoard)) {
                              encountered.add(encodedBoard);
                              pathsToTry.add(new Path(newBoard, nextPath.getSteps() + 1));
                          }
                      }

                      if (column - 1 >= 0) {
                          int[][] newBoard = copyBoard(nextPath.getBoard());

                          int temp = newBoard[row][column - 1];
                          newBoard[row][column - 1] = newBoard[row][column];
                          newBoard[row][column] = temp;

                          String encodedBoard = Arrays.deepToString(newBoard);
                          if (!encountered.contains(encodedBoard)) {
                              encountered.add(encodedBoard);
                              pathsToTry.add(new Path(newBoard, nextPath.getSteps() + 1));
                          }
                      }

                      if (column + 1 < columns) {
                          int[][] newBoard = copyBoard(nextPath.getBoard());

                          int temp = newBoard[row][column + 1];
                          newBoard[row][column + 1] = newBoard[row][column];
                          newBoard[row][column] = temp;

                          String encodedBoard = Arrays.deepToString(newBoard);
                          if (!encountered.contains(encodedBoard)) {
                              encountered.add(encodedBoard);
                              pathsToTry.add(new Path(newBoard, nextPath.getSteps() + 1));
                          }
                      }
                  }
              }
          }
      }
      
      return -1;
  }
  
  private static int[][] copyBoard(int[][] board) {
      int[][] copyOfBoard = new int[board.length][board[0].length];
      for (int row = 0; row < board.length; row++) {
          for (int column = 0; column < board[0].length; column++) {
              copyOfBoard[row][column] = board[row][column];
          }
      }
      return copyOfBoard;
  }
}

class Path {
  private int[][] board;
  private int steps;
  
  Path(int[][] board, int steps) {
      this.board = board;
      this.steps = steps;
  }
  
  int[][] getBoard() {
      return board;
  }
  
  int getSteps() {
      return steps;
  }
}
