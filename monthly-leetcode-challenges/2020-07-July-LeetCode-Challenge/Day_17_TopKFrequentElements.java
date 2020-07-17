class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> valToCountMap = new HashMap<>();
        for (int num : nums) {
            if (!valToCountMap.containsKey(num)) {
                valToCountMap.put(num, 1);
            } else {
                valToCountMap.put(num, valToCountMap.get(num) + 1);
            }
        }

        List<Integer> l = new ArrayList<>();
        for (int num : valToCountMap.keySet()) {
            l.add(num);
        }

        l.sort((a, b) -> valToCountMap.get(b) - valToCountMap.get(a));


        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = l.get(i);
        }

        return result;
    }
}
