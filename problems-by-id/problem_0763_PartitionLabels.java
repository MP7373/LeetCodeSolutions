class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (!lastIndexMap.containsKey(S.charAt(i))) {
                lastIndexMap.put(S.charAt(i), i);
            }
        }

        int index = 0;
        int partStart = 0;
        int partEnd = 0;
        
        List<Integer> parts = new ArrayList<>();
        while (index < S.length()) {
            partEnd = Math.max(partEnd, lastIndexMap.get(S.charAt(index)));
            if (index == S.length() - 1 || index == partEnd) {
                parts.add(index - partStart + 1);
                partStart = index + 1;
                partEnd = partStart;
            }
            index++;
        }
        
        return parts;
    }
}
