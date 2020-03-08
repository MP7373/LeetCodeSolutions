import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCounts = new HashMap<>();
        
        for (String word : words) {
            if (!wordCounts.containsKey(word)) {
                wordCounts.put(word, 1);
            } else {
                wordCounts.put(word, wordCounts.get(word) + 1);
            }
        }
        
        List<String> res = new ArrayList<>(wordCounts.keySet());
        
        res.sort((a, b) -> {
            int countComparison = wordCounts.get(b) - wordCounts.get(a);
            if (countComparison != 0) {
                return countComparison;
            }
            
            return a.compareTo(b);
        });
        
        return res.subList(0, k);
    }
}
