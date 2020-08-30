class Solution {
  public int[] findRightInterval(int[][] intervals) {
      int n = intervals.length;
      Interval[] ranges = new Interval[n];
      Interval[] rangesEnd = new Interval[n];
      Interval[] unsorted = new Interval[n];;

      for (int i = 0; i < n; i++) {
          Interval inter = new Interval(intervals[i], i);
          ranges[i] = inter;
          rangesEnd[i] = inter;
          unsorted[i] = inter;
      }

      Arrays.sort(ranges, (a, b) -> a.range[0] - b.range[0]);
      Arrays.sort(rangesEnd, (a, b) -> a.range[1] - b.range[1]);

      int i = 0;

      for (Interval val : rangesEnd) {
          while (i < n && ranges[i].range[0] < val.range[1]) {
              i++;
          }

          if (i < n) {
              val.right = ranges[i].index;
          } else {
              val.right = -1;
          }
      }

      int[] res = new int[n];
      for (i = 0; i < n; i++) {
          res[i] = unsorted[i].right;
      }

      return res;
  }
}

class Interval {
  int[] range;
  int index;
  int right = 0;

  Interval(int[] r, int i) {
      range = r;
      index = i;
  }
}
