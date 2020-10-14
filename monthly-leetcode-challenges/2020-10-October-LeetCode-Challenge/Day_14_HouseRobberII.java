class Solution {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        var maxWithRight = nums[0];
        var maxWithoutRight = 0;
        for (var i = 1; i < nums.length - 1; i++) {
            var num = nums[i];
            var newMaxWithRight = num + maxWithoutRight;
            maxWithoutRight = Math.max(maxWithoutRight, maxWithRight);
            maxWithRight = newMaxWithRight;
        }

        var max1 = Math.max(maxWithoutRight, maxWithRight);

        maxWithRight = nums[1];
        maxWithoutRight = 0;
        for (var i = 2; i < nums.length; i++) {
            var num = nums[i];
            var newMaxWithRight = num + maxWithoutRight;
            maxWithoutRight = Math.max(maxWithoutRight, maxWithRight);
            maxWithRight = newMaxWithRight;
        }

        return Math.max(max1, Math.max(maxWithoutRight, maxWithRight));
    }
}
