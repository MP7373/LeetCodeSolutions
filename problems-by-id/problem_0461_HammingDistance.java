class Solution {
  public int hammingDistance(int x, int y) {
      var matchingBits = 0;

      for (var i = 0; i < 31; i++) {
          if ((1 & ~(x ^ y)) == 1) {
              matchingBits++;
          }

          x >>= 1;
          y >>= 1;
      }

      return 31 - matchingBits;
  }
}
