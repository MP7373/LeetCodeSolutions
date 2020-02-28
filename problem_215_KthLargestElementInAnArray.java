class Solution {
    
  public int findKthLargest(int[] nums, int k) {
      int start = 0;
      int end = nums.length - 1;
      
      while (true) {
          int pivot = (int) (start + Math.floor(Math.random() * (end - start)));

          int temp = nums[start];
          nums[start] = nums[pivot];
          nums[pivot] = temp;
          
          pivot = start;
          int right = end;
          while (pivot + 1 <= right) {
              if (nums[pivot] > nums[pivot + 1]) {
                  temp = nums[pivot];
                  nums[pivot] = nums[++pivot];
                  nums[pivot] = temp;
              } else {
                  temp = nums[pivot + 1];
                  nums[pivot + 1] = nums[right];
                  nums[right--] = temp;
              }
          }

          if (pivot == nums.length - k) {
              return nums[pivot];
          }

          if (pivot > nums.length - k) {
              end = pivot - 1;
              continue;
          }

          start = pivot + 1;
      }
  }
}
