class Solution {
  private int minCost = Integer.MAX_VALUE;
  private int[] mins;

  public int mincostTickets(int[] days, int[] costs) {
      int[] mins = new int[days.length + 1];
      Arrays.fill(mins, Integer.MAX_VALUE);
      this.mins = mins;

      minCost = Integer.MAX_VALUE;
      minCost(days, costs, 0, 0);

      return minCost;
  }

  private void minCost(int[] days, int[] costs, int index, int cost) {
      if (index >= days.length) {
          minCost = Math.min(minCost, cost);
          return;
      }

      if (cost >= mins[index]) {
          return;
      }
      mins[index] = cost;

      int startingIndex = index;

      int exp = days[startingIndex] + 1;
      while (index < days.length && exp > days[index]) {
          index++;
      }
      minCost(days, costs, index, cost + costs[0]);

      exp = days[startingIndex] + 7;
      while (index < days.length && exp > days[index]) {
          index++;
      }
      minCost(days, costs, index, cost + costs[1]);

      exp = days[startingIndex] + 30;
      while (index < days.length && exp > days[index]) {
          index++;
      }
      minCost(days, costs, index, cost + costs[2]);
  }
}
