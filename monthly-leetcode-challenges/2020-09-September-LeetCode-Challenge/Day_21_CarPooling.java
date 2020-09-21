class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        var tripsList = Arrays.asList(trips);
        tripsList.sort((a, b) -> a[1] - b[1]);

        var q = new PriorityQueue<Integer>();

        for (int[] trip : tripsList) {
            while(!q.isEmpty() && trip[1] >= q.peek()) {
                q.poll();
            }

            if (q.size() + trip[0] > capacity) {
                return false;
            }

            for (int i = 0; i < trip[0]; i++) {
                q.add(trip[2]);
            }
        }

        return true;
    }
}
