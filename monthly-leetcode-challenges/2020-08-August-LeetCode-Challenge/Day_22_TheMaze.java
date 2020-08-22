class Solution {
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
      boolean[][] visited = new boolean[maze.length][];
      for (int y = 0; y < maze.length; y++) {
          visited[y] = new boolean[maze[0].length];

          for (int x = 0; x < maze[0].length; x++) {
              visited[y][x] = false;
          }
      }

      return dfs(maze, visited, start[0], start[1], destination[0], destination[1], "");
  }

  private boolean dfs(int[][] maze, boolean[][] visited, int y, int x, int goalY, int goalX, String path) {
      if (y == goalY && x == goalX) {
          return true;
      }

      if (visited[y][x] == true) {
          return false;
      }
      visited[y][x] = true;

      if (!path.equals("vertical")) {
          int upY = y - 1;
          if (upY >= 0 && maze[upY][x] == 0) {
              while (upY >= 0 && maze[upY][x] == 0) {
                  upY--;
              }
              upY++;

              if (dfs(maze, visited, upY, x, goalY, goalX, "vertical")) {
                  return true;
              }
          }

          int downY = y + 1;
          if (downY < maze.length && maze[downY][x] == 0) {
              while (downY < maze.length && maze[downY][x] == 0) {
                  downY++;
              }
              downY--;

              if (dfs(maze, visited, downY, x, goalY, goalX, "vertical")) {
                  return true;
              }
          }
      }

      if (!path.equals("horizontal")) {
          int leftX = x - 1;
          if (leftX >= 0 && maze[y][leftX] == 0) {
              while (leftX >= 0 && maze[y][leftX] == 0) {
                  leftX--;
              }
              leftX++;

              if (dfs(maze, visited, y, leftX, goalY, goalX, "horizontal")) {
                  return true;
              }
          }

          int rightX = x + 1;
          if (rightX < maze[0].length && maze[y][rightX] == 0) {
              while (rightX < maze[0].length && maze[y][rightX] == 0) {
                  rightX++;
              }
              rightX--;

              if (dfs(maze, visited, y, rightX, goalY, goalX, "horizontal")) {
                  return true;
              }
          }
      }

      return false;
  }
}
