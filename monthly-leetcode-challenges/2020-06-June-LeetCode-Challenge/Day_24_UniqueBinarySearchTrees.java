class Solution {
    public int numTrees(int n) {
        var map = new HashMap<Integer, Integer>();

        for (var i = 1; i <= n; i++) {
            var uniqueTrees = 0;

            for (var j = 1; j <= i; j++) {
                var leftTrees = map.getOrDefault(j - 1, 1);
                var rightTrees = map.getOrDefault(i - j, 1);

                uniqueTrees += leftTrees * rightTrees;
            }
            
            map.put(i, uniqueTrees);
        }
        
        return map.get(n);
    }
}
