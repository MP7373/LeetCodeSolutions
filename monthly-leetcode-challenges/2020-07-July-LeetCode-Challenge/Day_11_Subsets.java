class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var set = new TreeSet<Integer>();
        for (var n : nums) {
            set.add(n);
        }

        var result = new ArrayList<List<Integer>>();
        process(new TreeSet<Integer>(), set, new HashSet<String>(), result);
        return result;
    }

    public void process(
        Set<Integer> usedSet,
        Set<Integer> wholeSet,
        Set<String> used,
        List<List<Integer>> subsets
    ) {
        var hash = "";
        for (var n : usedSet) {
            hash += "," + n;
        }

        if (!used.contains(hash)) {
            used.add(hash);
            var list = new ArrayList<Integer>();
            for (var n : usedSet) {
                list.add(n);
            }
            subsets.add(list);
        } else {
            return;
        }

        var setCopy = new HashSet<Integer>();
        for (var n : wholeSet) {
            setCopy.add(n);
        }

        for (var n : setCopy) {
            wholeSet.remove(n);
            usedSet.add(n);
            process(usedSet, wholeSet, used, subsets);
            usedSet.remove(n);
            wholeSet.add(n);
        }
    }
}
