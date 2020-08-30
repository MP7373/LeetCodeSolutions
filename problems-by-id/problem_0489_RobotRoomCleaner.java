/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
  private final int[] xModifiers = new int[] { 0, 1, 0, -1 };
  private final int[] yModifiers = new int[] { 1, 0, -1, 0 };
  private final int[] oppositeDirection = new int[] { 2, 3, 0, 1 };

  public void cleanRoom(Robot robot) {
      Set<String> unreachable = new HashSet<>();
      Map<String, Set<Integer>> visited = new HashMap<>();
      int x = 0;
      int y = 0;
      int dir = 0;
      ArrayDeque<Integer> path = new ArrayDeque<>();

      String key = "";
      do {
          key = x + "," + y;
          if (!visited.containsKey(key)) {
              visited.put(key, new HashSet<>());
          }
          Set<Integer> directionsTriedFromHere = visited.get(key);

          robot.clean();

          for (int i = 0; i < 4; i++) {
              dir = (dir + 1) % 4;
              robot.turnRight();

              if (!directionsTriedFromHere.contains(dir)) {
                  directionsTriedFromHere.add(dir);

                  int nextX = x + xModifiers[dir];
                  int nextY = y + yModifiers[dir];

                  String nextKey = nextX + "," + nextY;
                  if (
                      !unreachable.contains(nextKey) &&
                      !(visited.containsKey(nextKey) && visited.get(nextKey).size() == 4)
                  ) {
                      boolean reachable = robot.move();

                      if (reachable) {
                          path.push(dir);
                          x = nextX;
                          y = nextY;

                          break;
                      } else {
                          unreachable.add(nextKey);
                      }
                  }
              }

              if (i == 3 && !path.isEmpty()) {
                  while (!path.isEmpty() && visited.containsKey(key) && visited.get(key).size() == 4) {
                      int goBackDir = oppositeDirection[path.pop()];
                      tryGoDirection(goBackDir, dir, robot);
                      dir = goBackDir;
                      x = x + xModifiers[dir];
                      y = y + yModifiers[dir];
                      key = x + "," + y;
                  }
              }
          }
      } while (!path.isEmpty() || (visited.containsKey(key) && visited.get(key).size() < 4));
  }

  private boolean tryGoDirection(int directionToGo, int directionFacing, Robot robot) {
      while (directionFacing != directionToGo) {
          directionFacing = (directionFacing + 1) % 4;
          robot.turnRight();
      }

      return robot.move();
  }
}
