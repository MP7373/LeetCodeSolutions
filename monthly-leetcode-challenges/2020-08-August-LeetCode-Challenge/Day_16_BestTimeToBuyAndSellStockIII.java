class Solution {
  public int maxProfit(int[] prices) {
      if (prices == null || prices.length < 1) {
          return 0;
      }

      int min = prices[0];
      int[] minToLeft = new int[prices.length];
      for (int i = 0; i < prices.length; i++) {
          min = Math.min(min, prices[i]);
          minToLeft[i] = min;
      }

      int max = prices[prices.length - 1];
      int[] maxToRight = new int[prices.length];
      for (int i = prices.length - 1; i >= 0; i--) {
          max = Math.max(max, prices[i]);
          maxToRight[i] = max;
      }

      int[] fromStartToIMaxes = new int[prices.length];
      int maxFromStart = prices[0] - minToLeft[0];
      for (int i = 0; i < prices.length; i++) {
          fromStartToIMaxes[i] = Math.max(maxFromStart, prices[i] - minToLeft[i]);
          maxFromStart = Math.max(maxFromStart, fromStartToIMaxes[i]);
      }

      int[] fromIToEndMaxes = new int[prices.length];
      int maxFromI = maxToRight[prices.length - 1] - prices[prices.length - 1];
      for (int i = prices.length - 1; i >= 0; i--) {
          fromIToEndMaxes[i] = Math.max(maxFromI, maxToRight[i] - prices[i]);
          maxFromI = Math.max(maxFromI, fromIToEndMaxes[i]);
      }

      max = Math.max(fromStartToIMaxes[prices.length - 1], fromIToEndMaxes[0]);
      for (int i = 0; i < prices.length - 1; i++) {
          max = Math.max(max, fromStartToIMaxes[i] + fromIToEndMaxes[i + 1]);
      }

      return max;
  }
}
