class Solution {
  private final long[] areas;
  private final long totalArea;
  private final int[][] rects;

  public Solution(int[][] rects) {
      this.rects = rects;
      areas = new long[rects.length];

      long runningArea = 0L;

      for (int i = 0; i < rects.length; i++) {
          int[] rect = rects[i];
          long area = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
          runningArea += area;
          areas[i] = runningArea;
      }

      totalArea = runningArea;
  }

  public int[] pick() {
      long randomArea = (long) (Math.random() * totalArea);

      int left = 0;
      int right = areas.length - 1;

      while (left < right) {
          int mid = left + (right - left) / 2;

          if (areas[mid] <= randomArea) {
              left = mid + 1;
          } else {
              right = mid;
          }
      }

      int[] rect = rects[left];
      return new int[] {
          rect[0] + (int) (Math.random() * (rect[2] - rect[0] + 1)),
          rect[1] + (int) (Math.random() * (rect[3] - rect[1] + 1))
      };
  }
}

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(rects);
* int[] param_1 = obj.pick();
*/
