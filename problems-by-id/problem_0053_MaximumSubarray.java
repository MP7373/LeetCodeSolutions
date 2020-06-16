class Solution {
  public int maxSubArray(int[] nums) {
      var max = nums[0];
      var sum = 0;

      for (var num : nums) {
          sum = Math.max(num, sum + num);
          
          if (sum > max) {
              max = sum;
          }
      }
      
      return max;
  }
}
