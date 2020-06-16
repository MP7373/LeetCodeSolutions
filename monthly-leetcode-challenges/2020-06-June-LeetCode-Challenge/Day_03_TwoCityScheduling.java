class Solution {
  public int twoCitySchedCost(int[][] costs) {
      Arrays.sort(costs, (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]));

      var cost = 0;
      var left = costs.length / 2;
      var right = left;
      for (var i = 0; i < costs.length; i++) {
          if (costs[i][0] < costs[i][1]) {
              if (left > 0) {
                  cost += costs[i][0];
                  left--;
              } else {
                  cost += costs[i][1];
                  right--;
              }
          } else {
              if (right > 0) {
                  cost += costs[i][1];
                  right--;
              } else {
                  cost += costs[i][0];
                  left--;
              }
          }
      }

      return cost;
  }
}
