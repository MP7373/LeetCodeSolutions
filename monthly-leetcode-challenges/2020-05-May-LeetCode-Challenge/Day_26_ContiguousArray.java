class Solution {
    public int findMaxLength(int[] nums) {
        var heightToIndexMap = new HashMap<Integer, Integer>();
        var height = 0;
        var maxLength = 0;

        heightToIndexMap.put(0, -1);
        for (var i = 0; i < nums.length; i++) {
            height += nums[i] == 1 ? 1 : -1;
            
            if (heightToIndexMap.containsKey(height) && i - heightToIndexMap.get(height) >= maxLength) {
                maxLength = i - heightToIndexMap.get(height);
            }
            
            if (!heightToIndexMap.containsKey(height)) {
                heightToIndexMap.put(height, i);
            }
        }
        
        return maxLength;
    }
}
