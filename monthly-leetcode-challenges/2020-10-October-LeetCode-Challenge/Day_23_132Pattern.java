class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        var n = nums.length;

        var maxLessThanCurToRight = new int[n];
        for (var i = n - 1; i >= 0; i--) {
            maxLessThanCurToRight[i] = Integer.MIN_VALUE;

            for (var j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    maxLessThanCurToRight[i] = Math.max(maxLessThanCurToRight[i], nums[j]);
                }
            }
        }

        var minToLeft = nums[0];
        for (var i = 1; i < n; i++) {
            if (nums[i] > minToLeft && maxLessThanCurToRight[i] > minToLeft) {
                return true;
            }

            minToLeft = Math.min(minToLeft, nums[i]);
        }

        return false;
    }
}
