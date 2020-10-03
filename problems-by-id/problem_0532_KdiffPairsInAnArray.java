class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        var uniqueNums = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        var pairs = 0;
        for (var a : uniqueNums.keySet()) {
            var b = a + k;

            if (uniqueNums.containsKey(b)) {
                if ((a == b && uniqueNums.get(a) > 1) || a != b) {
                    pairs++;
                }
            }
        }

        return pairs;
    }
}
