class Solution {
  public int compareVersion(String version1, String version2) {
      String[] v1 = version1.split("\\.");
      String[] v2 = version2.split("\\.");

      int len = Math.min(v1.length, v2.length);

      int i = -1;
      while (++i < len) {
          int dif = Integer.parseInt(v1[i]) - Integer.parseInt(v2[i]);

          if (dif > 0) {
              return 1;
          }

          if (dif < 0) {
              return -1;
          }
      }

      while (i < v1.length) {
          if (Integer.parseInt(v1[i++]) > 0) {
              return 1;
          }
      }

      while (i < v2.length) {
          if (Integer.parseInt(v2[i++]) > 0) {
              return -1;
          }
      }

      return 0;
  }
}
