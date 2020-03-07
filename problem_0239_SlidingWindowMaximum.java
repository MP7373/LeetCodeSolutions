import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }

        int[] maxes = new int[nums.length - k  + 1];
        Map<Integer, Integer> usageCount = new HashMap<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(nums.length, (a, b) -> b - a);
        
        for (int i = 0; i < nums.length; i++) {
            if (!usageCount.containsKey(nums[i]) || usageCount.get(nums[i]) == 0) {
                maxQueue.add(nums[i]);
                usageCount.put(nums[i], 1);
            } else {
                usageCount.put(nums[i], usageCount.get(nums[i]) + 1);
            }
            
            if (i >= k - 1) {
                maxes[i - k + 1] = maxQueue.peek();
            }

            if (i + 1 - k >= 0) {
                if (usageCount.containsKey(nums[i + 1 - k])) {
                    usageCount.put(nums[i + 1 - k], usageCount.get(nums[i + 1 - k]) - 1);
                    if (usageCount.get(nums[i + 1 - k]) == 0 && maxQueue.peek() == nums[i + 1 - k]) {
                        maxQueue.poll();
                        while (
                           maxQueue.size() > 0 &&
                           (!usageCount.containsKey(maxQueue.peek()) ||
                           usageCount.get(maxQueue.peek()) == 0)
                        ) {
                            maxQueue.poll();
                        }
                    }                
                }
            }
        }
        
        return maxes;
    }
}
