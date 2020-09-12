class Solution {
  public String getPermutation(int n, int k) {
      var list = new ArrayList<Integer>();
      for (var i = 1; i <= n; i++) {
          list.add(i);
      }

      var factorial = 1;
      for (var i = 1; i <= n; i++) {
          factorial *= i;
      }

      var result = 0;
      var multiplier = Math.pow(10, n - 1);
      var largest = n;

      k -= 1;
      for (var i = 0; i < n - 1; i++) {
          factorial /= largest;
          largest--;

          var nextDigitIndex = k / factorial;
          k %= factorial;

          result += list.get((int) nextDigitIndex) * multiplier;

          list.remove((int) nextDigitIndex);
          multiplier /= 10;
      }

      result += list.get(0);

      return "" + result;
  }
}
