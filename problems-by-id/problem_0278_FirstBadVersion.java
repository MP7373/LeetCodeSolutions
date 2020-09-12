/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
      return firstBadVersion(1, n);
  }

  public int firstBadVersion(int left, int right) {
      int mid = left + (right - left) / 2;

      var isBad = isBadVersion(mid);

      if (isBad && (mid == 1 || !isBadVersion(mid - 1))) {
          return mid;
      }

      if (isBad) {
          return firstBadVersion(left, mid - 1);
      }

      return firstBadVersion(mid + 1, right);
  }
}
