class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals[0] == null || intervals[0].length < 1) {
            return 0;
        }

        var intervalList = new ArrayList<int[]>();
        for (var interval : intervals) {
            intervalList.add(interval);
        }

        intervalList.sort((a, b) -> {
            var startDif = a[0] - b[0];
            if (startDif != 0) {
                return startDif;
            }

            return b[1] - a[1];
        });

        var left = -1;
        var right = -1;
        var count = 0;
        for (var i = 0; i < intervalList.size(); i++) {
            var cur = intervalList.get(i);
            var nextLeft = cur[0];
            var nextRight = cur[1];

            if (nextLeft <= right) {
                if (nextRight > right) {
                    count++;
                    left = nextLeft;
                    right = nextRight;
                }
            } else {
                count++;
                left = nextLeft;
                right = nextRight;
            }
        }

        return count;
    }
}
