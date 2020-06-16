class Solution {
    public boolean canJump(int[] nums) {
        var maxReachable = 0;
        
        for (var i = 0; i < nums.length; i++)  {
            if (i > maxReachable) {
                return false;
            }
            
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        
        return true;
    }
}
