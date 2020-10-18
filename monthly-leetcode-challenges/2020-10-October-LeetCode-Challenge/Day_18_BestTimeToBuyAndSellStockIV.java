class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length < 2) {
            return 0;
        }

        var maxProfit = 0;
        if (2 * k > prices.length) {
            for (var i = 1; i < prices.length; i++) {
                maxProfit += Math.max(0, prices[i] - prices[i - 1]);
            }

            return maxProfit;
        }

        var dp = new int[prices.length][k + 1][2];
        for (var i = 0; i < dp.length; i++) {
            for (var j = 0; j <= k; j++) {
                dp[i][j][0] = Integer.MIN_VALUE + 1000;
                dp[i][j][1] = Integer.MIN_VALUE + 1000;
            }
        }

        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];

        for (var i = 1; i < prices.length; i++) {
            for (var j = 0; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);

                if (j > 0) {
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
                }

                if (i == prices.length - 1) {
                    maxProfit = Math.max(maxProfit, dp[i][j][0]);
                }
            }
        }

        return maxProfit;
    }
}
