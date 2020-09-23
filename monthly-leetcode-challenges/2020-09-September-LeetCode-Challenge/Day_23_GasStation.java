class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        var startsTried = new HashSet<Integer>();

        int start = 0;
        int gasLeft = 0;
        int steps = 0;
        int index = start;
        while (startsTried.size() < n) {
            gasLeft = gasLeft + gas[index] - cost[index];

            if (gasLeft < 0) {
                startsTried.add(start);

                if (startsTried.size() >= n) {
                    return -1;
                }

                do {
                    index = (index + 1) % n;
                } while (startsTried.contains(index));

                start = index;
                gasLeft = 0;
                steps = 0;
            } else {
                steps++;

                if (steps >= n) {
                    return start;
                }

                index = (index + 1) % n;
            }
        }

        return -1;
    }
}
