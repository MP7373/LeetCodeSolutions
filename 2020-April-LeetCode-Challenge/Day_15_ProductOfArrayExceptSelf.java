class Solution {
    public int[] productExceptSelf(int[] nums) {
        var productsFromLeft = new int[nums.length];
        var productsFromRight = new int[nums.length];
        
        productsFromLeft[0] = nums[0];
        for (var i = 1; i < nums.length; i++) {
            productsFromLeft[i] = nums[i] * productsFromLeft[i - 1];
        }
        
        productsFromRight[nums.length - 1] = nums[nums.length - 1];
        for (var i = nums.length - 2; i >= 0; i--) {
            productsFromRight[i] = nums[i] * productsFromRight[i + 1];
        }
        
        nums[0] = productsFromRight[1];
        for (var i = 1; i < nums.length - 1; i++) {
            nums[i] = productsFromLeft[i - 1] * productsFromRight[i + 1];
        }
        nums[nums.length - 1] = productsFromLeft[nums.length - 2];
        
        return nums;
    }
}
