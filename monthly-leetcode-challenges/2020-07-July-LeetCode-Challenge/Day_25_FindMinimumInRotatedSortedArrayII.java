class Solution {
  public int findMin(int[] nums) {
      int left = 0;
      int right = nums.length - 1;

      while (right - left >= 0) {
          if (nums[left] < nums[right]) {
              return nums[left];
          }

          if (nums[left] == nums[right]) {
              while (right > left && nums[left] == nums[right]) {
                  right--;
              }

              if (left == right) {
                  return nums[left];
              }
              continue;
          }

          int mid = left + (right - left) / 2;
          if (right - left == 1) {
              return nums[right];
          }

          if (nums[left] < nums[mid]) {
              left = mid + 1;
          } else if (nums[left] > nums[mid]) {
              right = mid;
          } else {
              int goLeft = mid - 1;
              while (goLeft > left && nums[goLeft] == nums[left]) {
                  goLeft--;
              }

              if (goLeft > left) {
                  right = goLeft;
              } else {
                  int goRight = mid + 1;
                  while (goRight < right && nums[goRight] == nums[left]) {
                      goRight++;
                  }
                  if (goRight < right) {
                      left = goRight;
                  } else {
                      return nums[right];
                  }
              }
          }
      }

      return nums[left];
  }
}
