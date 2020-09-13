class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(k, n, new ArrayList<>(), new LinkedList<>(), 1, 0);
    }
    
    private List<List<Integer>> combinationSum3(
        int k,
        int n,
        List<List<Integer>> combinations,
        LinkedList<Integer> combination,
        int digit,
        int sum
    ) {
        if (combination.size() == k) {
            if (sum == n) {
                combinations.add(new ArrayList<>(combination));
            }
            return combinations;
        }

        int stepsLeft = k - combination.size();
        if (
            digit == 10 ||
            sum + digit > n ||
            sum + stepsLeft * 9 - (stepsLeft * (stepsLeft + 1)) / 2 + stepsLeft < n
        ) {
            return combinations;
        }
        
        combinationSum3(k, n, combinations, combination, digit + 1, sum);

        combination.add(digit);
        combinationSum3(k, n, combinations, combination, digit + 1, sum + digit);
        combination.removeLast();
        
        return combinations;
    }
}
