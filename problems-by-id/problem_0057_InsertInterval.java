class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
      int n = intervals.length;
      List<int[]> after = new ArrayList<>();

      int i = 0;
      while (i < n  && isAfter(newInterval, intervals[i])) {
          after.add(intervals[i++]);
      }

      if (i == n) {
          after.add(newInterval);

          return getResultFromList(after);
      } else if (isBefore(newInterval, intervals[i])) {
          after.add(newInterval);

          while (i < n) {
              after.add(intervals[i++]);
          }

          return getResultFromList(after);
      }

      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

      i++;

      while (i < n  && isOverlapping(newInterval, intervals[i])) {
          newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

          i++;
      }

      after.add(newInterval);

      while (i < n) {
          after.add(intervals[i++]);
      }

      return getResultFromList(after);
  }

  private boolean isBefore(int[] a, int[] b) {
      return a[1] < b[0];
  }

  private boolean isAfter(int[] a, int[] b) {
      return b[1] < a[0];
  }

  private boolean isOverlapping(int[] a, int[] b) {
      return !isBefore(a, b) && !isAfter(a, b);
  }

  private int[][] getResultFromList(List<int[]> list) {
      int[][] res = new int[list.size()][];

      for (int i = 0; i < res.length; i++) {
          res[i] = list.get(i);
      }

      return res;
  }
}
