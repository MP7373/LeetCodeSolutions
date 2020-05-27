class Solution {
    
    private HashMap<Integer, Set<Integer>> dislikesMap = new HashMap<>();
    private Set<Integer> checked = new HashSet<>();
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        for (var dislike : dislikes) {
            if (!dislikesMap.containsKey(dislike[0])) {
                var set = new HashSet<Integer>();
                set.add(dislike[1]);
                
                dislikesMap.put(dislike[0], set);
            } else {
                dislikesMap.get(dislike[0]).add(dislike[1]);
            }
            
            if (!dislikesMap.containsKey(dislike[1])) {
                var set = new HashSet<Integer>();
                set.add(dislike[0]);
                
                dislikesMap.put(dislike[1], set);
            } else {
                dislikesMap.get(dislike[1]).add(dislike[0]);
            }
        }
        
        var group1 = new HashSet<Integer>();
        var group2 = new HashSet<Integer>();
        for (var num : dislikesMap.keySet()) {
            if (!process(group1, group2, num)) {
                return false;
            }
        }

        return true;
    }
    
    private boolean process(HashSet<Integer> group1, HashSet<Integer> group2, int person) {
        if (!checked.contains(person)) {
            checked.add(person);

            var dislikes = dislikesMap.get(person);

            var any1 = false;
            for (var d : dislikes) {
                if (group1.contains(d)) {
                    any1 = true;
                }
            }
            
            var any2 = false;
            for (var d : dislikes) {
                if (group2.contains(d)) {
                    any2 = true;
                }
            }
            
            if (any1 && any2) {
                return false;
            } else if (any1) {
                group1.addAll(dislikes);
                group2.add(person);
            } else {
                group2.addAll(dislikes);
                group1.add(person);
            }
            
            for (var d : dislikes) {
                if (!process(group1, group2, d)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
