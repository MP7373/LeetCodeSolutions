class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        var index = 1;
        
        while (index <= num) {
            var copyRunEndIndex = index;
            
            for (var i = 0; index <= num && i < copyRunEndIndex; i++) {
                result[index++] = result[i] + 1;
            }
        }
        
        return result;
    }
}
