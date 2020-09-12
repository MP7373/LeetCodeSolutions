class Solution {
  public int rangeBitwiseAnd(int m, int n) {
      if (m == n) {
          return m;
      }

      var leftMask = (int) Math.pow(2, Math.ceil( Math.log(n) / Math.log(2))) - 1;
      var rightMask = ~((int) Math.pow(2, Math.floor(Math.log(m ^ n) / Math.log(2) + 1)) - 1);

      return n & leftMask & rightMask;
  }
}
