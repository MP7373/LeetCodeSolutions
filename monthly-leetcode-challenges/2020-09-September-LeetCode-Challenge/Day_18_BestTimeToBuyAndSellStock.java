class Solution {
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length < 1) {
          return 0;
      }

      var min = prices[0];
      var max = 0;

      for (var i = 1; i < prices.length; i++) {
          max = Math.max(max, prices[i] - min);
          min = Math.min(min, prices[i]);
      }

      return max;
    }
}
