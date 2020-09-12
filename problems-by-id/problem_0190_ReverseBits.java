public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
      var lastBit = n >= 0 ? 0 : 1;
      var num = 0;

      for (var i = 0; i < 31; i++) {
          num += n & 1;
          n = n >> 1;
          num = num << 1;
      }

      return num + lastBit;
  }
}
