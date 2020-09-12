class Solution {
  public int nthUglyNumber(int n) {
      var q = new PriorityQueue<Long>(1000, (a, b) -> a == b ? 0 : a < b ? -1 : 1);
      var used = new HashSet<Long>();
      q.add(1L);
      used.add(1L);

      long next = 0;
      do {
          next = q.poll();

          long twoTimes = next * 2L;
          if (!used.contains(twoTimes)) {
              q.add(twoTimes);
              used.add(twoTimes);
          }

          long threeTimes = next * 3L;
          if (!used.contains(threeTimes)) {
              q.add(threeTimes);
              used.add(threeTimes);
          }

          long fiveTimes = next * 5L;
          if (!used.contains(fiveTimes)) {
              q.add(fiveTimes);
              used.add(fiveTimes);
          }
      } while (--n > 0);

      return (int) next;
  }
}
