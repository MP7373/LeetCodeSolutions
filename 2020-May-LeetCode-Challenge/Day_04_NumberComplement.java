class Solution {
  public int findComplement(int num) {
      var originalNum = num;
      var mask = 0;
      
      while (num > 0) {
          num = num >>> 1;
          mask = (mask << 1) + 1;
      }
      
      return ~originalNum & mask;
  }
}
