class Solution {
    public int firstMissingPositive(int[] nums) {
        for (var i = 0; i < nums.length; i++) {
            if (
                nums[i] != i + 1 &&
                1 <= nums[i] &&
                nums[i] <= nums.length &&
                nums[i] != nums[nums[i] - 1]
            ) {
                var temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }

        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
