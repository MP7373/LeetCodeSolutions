import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        Set<Integer> set = new LinkedHashSet<>();
        
        generateAllPermutations(allPermutations, set, nums);
        
        return allPermutations;
    }
    
    private void generateAllPermutations(
        List<List<Integer>> allPermutations,
        Set<Integer> currentPermutation,
        int[] nums
    ) {
        if (currentPermutation.size() == nums.length) {
            List<Integer> list = new ArrayList<>();
            list.addAll(currentPermutation);
            allPermutations.add(list);
            return;
        }

        for (int num : nums) {
            if (!currentPermutation.contains(num)) {
                currentPermutation.add(num);
                generateAllPermutations(allPermutations, currentPermutation, nums);
                currentPermutation.remove(num);
            }
        }
    }
}
