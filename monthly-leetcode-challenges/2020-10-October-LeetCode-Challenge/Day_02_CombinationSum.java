class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(combinations, new LinkedList<>(), 0, target, 0, candidates);
        return combinations;
    }

    private void generateCombinations(
        List<List<Integer>> combinations,
        LinkedList<Integer> combination,
        int sum,
        int target,
        int index,
        int[] candidates
    ) {
        if (sum == target) {
            combinations.add(new ArrayList(combination));
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        int timesToPopOff = 0;
        while (sum <= target) {
            generateCombinations(combinations, combination, sum, target, index + 1, candidates);
            sum += candidates[index];
            combination.add(candidates[index]);
            timesToPopOff++;
        }

        while (timesToPopOff > 0) {
            combination.removeLast();
            timesToPopOff--;
        }
    }
}
