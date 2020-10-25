class Solution {
    public boolean winnerSquareGame(int n) {
        var willLose = new boolean[n + 1];
        willLose[0] = true;

        for (var i = 1; i <= n; i++) {
            var root = (int) Math.sqrt(i);
            willLose[i] = true;

            for (var j = root; j > 0; j--) {
                var nextVal = i - (j * j);

                if (willLose[nextVal]) {
                    willLose[i] = false;
                    break;
                }
            }
        }

        return !willLose[n];
    }
}
