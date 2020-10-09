class TwoSum {
    private final Map<Integer, Integer> counts = new HashMap();

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        counts.put(number, counts.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (var number : counts.keySet()) {
            var complement = value - number;

            if (complement == number) {
                if (counts.get(number) > 1) {
                    return true;
                }
            } else if (counts.containsKey(complement)) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
