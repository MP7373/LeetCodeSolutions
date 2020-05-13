class Solution {
  public int singleNonDuplicate(int[] nums) {
      return find(nums, 0, nums.length - 1);
  }
  
  private int find(int[] nums, int l, int r) {
      var mid = l + (r - l) / 2;
      
      if (
          ( mid == 0 || (nums[mid - 1] != nums[mid]) ) &&
          ( mid == nums.length - 1 || (nums[mid + 1] != nums[mid]) )
      ) {
          return nums[mid];
      }
      
      var odd = ((r - l + 1) / 2) % 2 == 1;
      
      if (odd) {
          if (nums[mid + 1] == nums[mid]) {
              return find(nums, l, mid - 1);
          }
          
          return find(nums, mid + 1, r);
      }
      
      if (nums[mid + 1] == nums[mid]) {
          return find(nums, mid + 2, r);
      }

      return find(nums, l, mid - 2);
  }
}
