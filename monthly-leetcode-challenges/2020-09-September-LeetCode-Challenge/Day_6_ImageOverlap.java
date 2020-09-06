class Solution {
  public int largestOverlap(int[][] a, int[][] b) {
      int maxOverlaps = 0;
      int n = a.length;

      for (int aRowOffset = -n + 1; aRowOffset < n; aRowOffset++) {
          for (int aColOffset = -n + 1; aColOffset < n; aColOffset++) {
              int overlaps = 0;

              for (int bRow = 0; bRow < n; bRow++) {
                  for (int bCol = 0; bCol < n; bCol++) {
                      int aRow = bRow + aRowOffset;
                      int aCol = bCol + aColOffset;

                      if (0 <= aRow && aRow < n && 0 <= aCol && aCol < n &&
                         a[aCol][aRow] == b[bCol][bRow] && a[aCol][aRow] == 1) {
                          overlaps++;
                      }
                  }
              }

              maxOverlaps = Math.max(maxOverlaps, overlaps);
          }
      }

      return maxOverlaps;
  }
}
