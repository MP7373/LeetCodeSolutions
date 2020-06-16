/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
  let i = 0
  while (i < nums.length) {
      const value = nums[i]
      
      if (value !== i + 1 && 1 <= value && value <= nums.length && nums[i] !== nums[value - 1]) {
          nums[i] = nums[value - 1]
          nums[value - 1] = value
      } else {
          i++
      }
  }
  
  for (let i = 0; i < nums.length; i++) {
      if (nums[i] !== i + 1) {
          return i + 1
      }
  }
  
  return nums.length + 1
};
