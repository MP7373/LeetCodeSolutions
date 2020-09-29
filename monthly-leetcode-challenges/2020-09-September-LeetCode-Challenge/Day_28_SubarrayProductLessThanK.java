class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length < 1) {
            return 0;
        }

        var product = 1;
        var run = new ArrayDeque<Integer>();
        var totalProductsLessThanK = 0;

        for (var i = 0; i < nums.length; i++) {
            product *= nums[i];
            run.add(nums[i]);

            while (product >= k && run.size() > 0) {
                product /= run.pollFirst();
            }

            totalProductsLessThanK += run.size();
        }

        return totalProductsLessThanK;
    }
}
