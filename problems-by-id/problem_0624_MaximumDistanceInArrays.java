class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        var minQ = new PriorityQueue<Integer>();
        var maxQ = new PriorityQueue<Integer>(arrays.size(), (a, b) -> b - a);

        for (var arr : arrays) {
            minQ.add(arr.get(0));
            maxQ.add(arr.get(arr.size() - 1));
        }

        int maxDistance = 0;
        for (var arr : arrays) {
            var min = minQ.peek();
            if (min == arr.get(0)) {
                var top = minQ.poll();
                min = minQ.peek();
                minQ.add(top);
            }

            var distance = arr.get(arr.size() - 1) - min;

            var max = maxQ.peek();
            if (max == arr.get(arr.size() - 1)) {
                var top = maxQ.poll();
                max = maxQ.peek();
                maxQ.add(top);
            }

            distance = Math.max(distance, max - arr.get(0));
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        return maxDistance;
    }
}
