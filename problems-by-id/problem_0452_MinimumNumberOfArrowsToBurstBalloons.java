class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

		Arrays.sort(points, (a, b) -> {
			var dif = (long) a[0] - (long) b[0];

			if (dif != 0) {
				return dif > 0 ? 1 : -1;
			}

			var d = ((long) a[1] - (long) b[1]);
            return d > 0 ? 1 : -1;
		});
        
        var arrows = 1;
        var right = points[0][1];
        
        for (var i = 1; i < points.length; i++) {
            if (points[i][0] > right) {
                arrows++;
                right = points[i][1];
            } else if (points[i][1] < right) {
                right = points[i][1];
            }
        }
        
        return arrows;
    }
}
