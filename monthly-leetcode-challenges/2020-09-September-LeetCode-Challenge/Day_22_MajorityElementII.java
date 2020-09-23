class Solution {
    List<Integer> majorityElements = new ArrayList<>();
    int n = 0;
    int[] nums = null;

    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        majorityElements = new ArrayList<>();
        n = nums.length;
        this.nums = nums;

        quickSelect(0, n);

        return majorityElements;
    }

    private void quickSelect(int l, int r) {
        if (majorityElements.size() >= 2 || majorityElements.size() >= n || r - l < 1) {
            return;
        }

        int p = l + (int) ((r - l) * Math.random());
        int pr = p;

        int temp = nums[l];
        nums[l] = nums[p];
        nums[p] = temp;

        p = l;
        pr = p;

        int rightBound = r;
        int i = pr + 1;
        while (i < rightBound) {
            if (nums[i] < nums[p]) {
                temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
                pr++;
            } else if (nums[i] == nums[p]) {
                pr++;
            } else {
                temp = nums[rightBound - 1];
                nums[rightBound - 1] = nums[i];
                nums[i] = temp;

                rightBound--;
            }

            i = pr + 1;
        }

        if (pr - p + 1 > n / 3) {
            majorityElements.add(nums[p]);
            if (majorityElements.size() >= 2 || majorityElements.size() >= n) {
                return;
            }
        }

        if (p - l > n / 3) {
            quickSelect(l, p);
        }

        if (r - pr > n / 3) {
            quickSelect(pr + 1, r);
        }
    }
}
