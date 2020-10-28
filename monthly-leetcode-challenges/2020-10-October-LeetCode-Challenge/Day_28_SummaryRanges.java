class Solution {
    public List<String> summaryRanges(int[] nums) {
        var ranges = new ArrayList<String>();

        Integer start = null;
        Integer end = null;
        for (var i = 0; i < nums.length; i++) {
            var num = nums[i];

            if (start == null) {
                start = num;
            } else {
                end = num;
            }

            if (i == nums.length - 1 || nums[i + 1] != num + 1) {
                if (end != null) {
                    ranges.add(start + "->" + end);
                } else {
                    ranges.add(Integer.toString(start));
                }

                start = null;
                end = null;
            }
        }

        return ranges;
    }
}
