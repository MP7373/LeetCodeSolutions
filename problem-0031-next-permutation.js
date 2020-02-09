/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {    
  let i = nums.length - 1;
  let max = [nums[i], i];
  
  while (--i >= 0) {
      let current = nums[i];
      
      if (max[0] > current) {
          
          for (let j = i + 1; j < nums.length; j++) {
              if (nums[j] < max[0] && nums[j] > current) {
                  max[0] = nums[j];
                  max[1] = j;
              }
          }
          
          let temp = max[0];
          max[0] = current;
          nums[i] = temp;
          nums[max[1]] = current;
          max[1] = i;
          
          if (i + 1 < nums.length - 1) {
              quickSort(nums, i + 1, nums.length - 1);
          }
          
          return nums;
      } else {
          max[0] = current;
          max[1] = i;
      }
  }
  
  nums.sort((a, b) => a - b);
  return nums;
};

function quickSort(arr, left, right) {
  if (left >= right) {
      return;
  }
  
  let pivot = left;
  
  let r = right;
  let i = left + 1;
  
  while (i <= r) {
      if (arr[pivot] >= arr[i]) {
          let temp = arr[pivot];
          arr[pivot] = arr[i];
          arr[i] = temp;
          pivot = i;
          
          i++;
      } else {
          let temp = arr[i];
          arr[i] = arr[r];
          arr[r] = temp;
          
          r--;
      }
  }
  
  quickSort(arr, left, pivot - 1);
  quickSort(arr, pivot + 1, right);
}
