class Solution {
  public void sortColors(int[] nums) {
      for (int i = 0, zeroIndex = 0, twoIndex = nums.length - 1; i <= twoIndex; i++) {
          if (nums[i] == 0) {
              nums[i] = 1;
              nums[zeroIndex++] = 0;
          } else if (nums[i] == 2) {
              nums[i--] = nums[twoIndex];
              nums[twoIndex--] = 2;
          }
      }
  }
}
