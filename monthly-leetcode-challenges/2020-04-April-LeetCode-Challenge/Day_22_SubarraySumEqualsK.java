class Solution {
    public int subarraySum(int[] nums, int k) {
        var sum = 0;
        for (var num : nums) {
            sum += num;
        }
        
        var subarraySum = 0;
        if (sum == k) {
            subarraySum++;
        }
        
        for (var windowSize = nums.length - 1; windowSize > 0; windowSize--) {
            sum -= nums[windowSize];
            
            var localSum = sum;
            if (localSum == k) {
                subarraySum++;
            }
            
            var left = 1;
            var right = windowSize;
            
            while (right < nums.length) {
                localSum -= nums[left - 1];
                localSum += nums[right];

                if (localSum == k) {
                    subarraySum++;
                }
                
                left++;
                right++;
            }
        }
        
        return subarraySum;
    }
}
