import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        var stonesQ = new PriorityQueue<Integer>(stones.length, (a, b) -> b - a);

        for (var stone : stones) {
            stonesQ.add(stone);
        }

        while (stonesQ.size() > 1) {
            var newStone = stonesQ.poll() - stonesQ.poll();

            if (newStone > 0) {
                stonesQ.add(newStone);
            }
        }

        return stonesQ.size() > 0 ? stonesQ.peek() : 0;
    }
}
