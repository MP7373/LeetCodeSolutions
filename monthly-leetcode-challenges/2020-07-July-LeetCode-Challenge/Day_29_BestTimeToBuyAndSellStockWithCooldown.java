class Solution {
  public int maxProfit(int[] prices) {
      int[] held = new int[prices.length + 1];
      int[] sold = new int[prices.length + 1];
      int[] reset = new int[prices.length + 1];

      held[0] = Integer.MIN_VALUE;
      sold[0] = Integer.MIN_VALUE;
      reset[0] = 0;
      for (int i = 1; i <= prices.length; i++) {
          held[i] = Math.max(held[i - 1], reset[i - 1] - prices[i - 1]);
          sold[i] = held[i - 1] + prices[i - 1];
          reset[i] = Math.max(reset[i - 1], sold[i - 1]);
      }

      return Math.max(sold[sold.length - 1], reset[reset.length - 1]);
  }
}
