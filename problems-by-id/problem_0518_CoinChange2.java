class Solution {
  private Map<String, Integer> memo;

  public int change(int amount, int[] coins) {
      memo = new HashMap<String, Integer>();
      return change(amount, coins, 0);
  }

  private int change(int amount, int[] coins, int index) {
      var key = amount + "," + index;
      if (memo.containsKey(key)) {
          return memo.get(key);
      }

      if (amount == 0) {
          memo.put(key, 1);
          return 1;
      }

      if (index >= coins.length) {
          memo.put(key, 0);
          return 0;
      }

      var sum = 0;
      for (var i = 0; amount - coins[index] * i >= 0; i++) {
          sum += change(amount - coins[index] * i, coins, index + 1);
      }

      memo.put(key, sum);
      return sum;
  }
}
