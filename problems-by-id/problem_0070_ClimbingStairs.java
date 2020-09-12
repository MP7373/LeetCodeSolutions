class Solution {
  public int climbStairs(int n) {
      int current = 1;
      int oneAhead = 0;
      int twoAhead = 0;

      for (int i = 0; i < n; i++) {
          if (i + 1 <= n) {
              oneAhead += current;
          }

          if (i + 2 <= n) {
              twoAhead += current;
          }

          current = oneAhead;
          oneAhead = twoAhead;
          twoAhead = 0;
      }

      return current;
  }
}
