import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        var sumToIndexMap = new HashMap<Integer, Integer>();
        var sum = 0;
        var maxLengthZeroSumSubarray = 0;
        
        sumToIndexMap.put(0, -1);
        
        for (var i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            
            if (!sumToIndexMap.containsKey(sum)) {
                sumToIndexMap.put(sum, i);
            }
            
            var longestZeroSumSubArrayEndingHere = i - sumToIndexMap.get(sum);

            if (longestZeroSumSubArrayEndingHere > maxLengthZeroSumSubarray) {
                maxLengthZeroSumSubarray = longestZeroSumSubArrayEndingHere;
            }
        }
        
        return maxLengthZeroSumSubarray;
    }
}
