class Solution {
  public int[] singleNumber(int[] nums) {
      int mask = 0;
      for (int num : nums) {
          mask ^= num;
      }

      int firstValue = mask;
      int mostRightOneMask = mask & -mask;
      for (int num : nums) {
          if ((mostRightOneMask & num) != 0) {
              firstValue ^= num;
          }
      }

      return new int[] { firstValue, firstValue ^ mask };
  }
}
