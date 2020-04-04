class Solution {
  public void moveZeroes(int[] nums) {
      var leftIndex = 0;
      var rightIndex = getNextNonZeroIndex(nums, 0);
      
      while (rightIndex < nums.length) {
          if (nums[leftIndex] == 0) {
              nums[leftIndex] = nums[rightIndex];
              nums[rightIndex] = 0;
              
              rightIndex = getNextNonZeroIndex(nums, rightIndex + 1);
          }

          leftIndex++;
          
          if (leftIndex >= rightIndex) {
              rightIndex = getNextNonZeroIndex(nums, rightIndex + 1);
          }
      }
  }
  
  private int getNextNonZeroIndex(int[] nums, int index) {
      while (index < nums.length && nums[index] == 0) {
          index++;
      }
      
      return index;
  }
}
