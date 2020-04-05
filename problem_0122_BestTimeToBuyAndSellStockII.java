class Solution {
  public int maxProfit(int[] prices) {
      if (prices == null || prices.length < 1) {
          return 0;
      }

      var profit = 0;

      for (var i = 0; i < prices.length - 1; i++) {
          if (prices[i] < prices[i + 1]) {
              var buyPrice = prices[i];
              
              var last = prices[i++];
              while (i < prices.length && prices[i] > last) {
                  last = prices[i++];
              }
              i--;
              
              profit += prices[i] - buyPrice;
          }
      }
      
      return profit;
  }
}
