class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            int postiveNum = Math.abs(num);

            if (nums[postiveNum - 1] < 0) {
                duplicates.add(postiveNum);
            }

            nums[postiveNum - 1] *= -1;
        }

        return duplicates;
    }
}
