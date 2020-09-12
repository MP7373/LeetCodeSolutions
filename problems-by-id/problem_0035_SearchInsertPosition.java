class Solution {
  public int searchInsert(int[] nums, int target) {
      return binarySearch(nums, 0, nums.length - 1, target);
  }

  private int binarySearch(int[] nums, int left, int right, int target) {
      var mid = left + (right - left) / 2;

      if (nums[mid] == target || (nums[mid] > target && (mid - 1 < 0 || nums[mid - 1] < target))) {
          return mid;
      }

      if (nums[mid] > target) {
          return binarySearch(nums, left, mid - 1, target);
      }

      if (mid == nums.length - 1) {
          return nums.length;
      }

      return binarySearch(nums, mid + 1, right, target);
  }
}
