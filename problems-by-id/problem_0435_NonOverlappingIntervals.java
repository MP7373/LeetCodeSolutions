class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
      List<int[]> intervalList = Arrays.asList(intervals);

      intervalList.sort((a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : a[1] - b[1]);

      int skips = 0;
      int index = 0;
      int nextIndex = index + 1;

      while (nextIndex < intervalList.size()) {
          int[] currentInterval = intervalList.get(index);
          int[] nextInterval = intervalList.get(nextIndex);

          if (currentInterval[1] > nextInterval[0]) {
              skips++;
              index = currentInterval[1] <= nextInterval[1] ? index : nextIndex;
          } else {
              index = nextIndex;
          }

          nextIndex++;
      }

      return skips;
  }
}
