class Solution {
    public int minMeetingRooms(int[][] intervals) {
        var meetingEndTimes = new HashMap<Integer, Integer>();

        var intervalList = new ArrayList<int[]>();
        var endIndexes = new ArrayList<Integer>();
        for (var interval : intervals) {
            intervalList.add(interval);
            endIndexes.add(interval[1]);
        }

        intervalList.sort((a, b) -> {
            var dif = a[0] - b[0];

            if (dif != 0) {
                return dif;
            }

            return a[1] - b[1];
        });

        endIndexes.sort((a, b) -> a - b);

        var endIndex = 0;
        var numberOfConcurrentMeetings = 0;
        var maxRooms = 0;
        for (var interval : intervalList) {
            var start = interval[0];
            var end = interval[1];

            while (endIndex < endIndexes.size() && endIndexes.get(endIndex) <= start) {
                if (meetingEndTimes.containsKey(endIndexes.get(endIndex))) {
                    meetingEndTimes.put(endIndexes.get(endIndex), meetingEndTimes.get(endIndexes.get(endIndex)) - 1);
                    numberOfConcurrentMeetings--;
                }
                endIndex++;
            }

            meetingEndTimes.put(end, meetingEndTimes.getOrDefault(end, 0) + 1);
            numberOfConcurrentMeetings++;
            maxRooms = Math.max(maxRooms, numberOfConcurrentMeetings);
        }

        return maxRooms;
    }
}
