class Solution {
  public int hIndex(int[] citations) {
      if (citations.length == 0) {
          return 0;
      }

      return hIndex(citations, 0, citations.length - 1);
  }

  private int hIndex(int[] citations, int left, int right) {
      var mid = left + (right - left) / 2;
      var h = Math.min(citations.length - mid, citations[mid]);
      var min = citations.length - mid;
      var isValidH = citations[mid] >= min;

      if (isValidH) {
          var oneLeftIsValidH = mid - 1 >= 0 && citations[mid - 1] >= citations.length - mid + 1;

          if (oneLeftIsValidH) {
              return hIndex(citations, left, mid - 1);
          }

          return h;
      }

      if (mid + 1 > right) {
          return 0;
      }

      return hIndex(citations, mid + 1, right);
  }
}
