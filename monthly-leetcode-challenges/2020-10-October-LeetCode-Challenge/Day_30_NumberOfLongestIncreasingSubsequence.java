class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        var lengths = new int[nums.length];
        var counts = new int[nums.length];
        Arrays.fill(counts, 1);

        for (var i = 0; i < nums.length; i++) {
            for (var j = 0; j < i; j++) {
               if (nums[j] < nums[i]) {
                   if (lengths[j] >= lengths[i]) {
                       lengths[i] = lengths[j] + 1;
                       counts[i] = counts[j];
                   } else if (lengths[j] + 1 == lengths[i]) {
                       counts[i] += counts[j];
                   }
               }
            }
        }

        var longest = 0;
        for (var len : lengths) {
            longest = Math.max(longest, len);
        }

        var count = 0;
        for (var i = 0; i < nums.length; i++) {
            if (longest == lengths[i]) {
                count += counts[i];
            }
        }

        return count;
    }
}
