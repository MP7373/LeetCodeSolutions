class Solution {
  public int rob(int[] nums) {
      if (nums == null || nums.length < 1) {
          return 0;
      }

      int withLastMax = nums[0];
      int notWithLastMax = 0;

      for (int i = 1; i < nums.length; i++) {
          int temp = withLastMax;
          withLastMax = notWithLastMax + nums[i];
          notWithLastMax = Math.max(notWithLastMax, temp);
      }

      return Math.max(withLastMax, notWithLastMax);
  }
}
