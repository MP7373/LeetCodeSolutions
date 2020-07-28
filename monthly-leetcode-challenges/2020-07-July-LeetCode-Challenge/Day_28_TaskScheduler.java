class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> q = new PriorityQueue<>(tasks.length, (a, b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()) {
            q.add(c);
        }

        Map<Character, Integer> timeoutQueue = new HashMap<>();
        int leastInterval = 0;
        while (q.size() > 0 || timeoutQueue.keySet().size() > 0) {
            if (q.size() > 0) {
                char c = q.poll();

                if (map.get(c) > 1) {
                    map.put(c, map.get(c) - 1);

                    timeoutQueue.put(c, n + 1);
                }
            }

            Map<Character, Integer> newTimeoutQueue = new HashMap<>();
            for (char key : timeoutQueue.keySet()) {
                int wait = timeoutQueue.get(key);

                if (wait > 1) {
                    newTimeoutQueue.put(key, wait - 1);
                } else {
                    q.add(key);
                }
            }
            timeoutQueue = newTimeoutQueue;

            leastInterval++;
        }

        return leastInterval;
    }
}
