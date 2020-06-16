class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        var start = findStart(nums);
        
        var leftCheck = binarySearch(nums, target, 0, start - 1);
        
        return leftCheck != -1 ? leftCheck : binarySearch(nums, target, start, nums.length - 1);
    }
    
    private int findStart(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return 0;
        }
        
        var left = 0;
        var right = nums.length;
        var start = left + (right - left) / 2;
        
        while (!( nums[start] < nums[0] && nums[start - 1] >= nums[0] )) {
            if (right - left == 1) {
                return nums[left] >= nums[0] ? right : left;
            }
            
            if (nums[start] > nums[0]) {
                left = start + 1;
            } else {
                right = start - 1;
            }
            
            start = left + (right - left) / 2;
        }
        
        return start;
    }
    
    private int binarySearch(int[] nums, int target, int left, int right) {
        if (right < left) {
            return - 1;
        }

        var middle = left + (right - left) / 2;
        
        if (nums[middle] == target) {
            return middle;
        }
        
        if (right <= left) {
            return - 1;
        }
        
        return nums[middle] > target ?
            binarySearch(nums, target, left, middle - 1) :
            binarySearch(nums, target, middle + 1, right);
    }
}
