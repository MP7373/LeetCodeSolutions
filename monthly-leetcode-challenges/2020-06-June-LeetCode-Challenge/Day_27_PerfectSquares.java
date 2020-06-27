class Solution {
    public int numSquares(int n) {
        var squaredNums = new HashSet<Integer>();

        for (var i = 1; i * i <= n; i++) {
            squaredNums.add(i * i);
        }
        
        var remainders = new HashSet<Integer>();
        remainders.add(n);
        
        var steps = 1;
        while (remainders.size() > 0) {
            var nextRemainders = new HashSet<Integer>();

            for (var remainder : remainders) {
                for (var squaredNum : squaredNums) {
                    var newRemainder = remainder - squaredNum;

                    if (newRemainder == 0) {
                        return steps;
                    } else if (newRemainder > 0) {
                        nextRemainders.add(newRemainder);
                    }
                }
            }
            
            remainders = nextRemainders;
            steps++;
        }
        
        return -1;
    }
}
