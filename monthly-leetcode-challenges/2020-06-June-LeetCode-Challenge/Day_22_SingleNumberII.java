class Solution {
    public int singleNumber(int[] nums) {
        var mask1 = 0;
        var mask2 = 0;
        
        for (var num : nums) {
            mask1 = ~mask2 & (mask1 ^ num);
            mask2 = ~mask1 & (mask2 ^ num);
        }
        
        return mask1;
    }
}
