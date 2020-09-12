class Solution {
  public String stringShift(String s, int[][] shift) {
      var finalShift = 0;

      for (var shif : shift) {
          finalShift += shif[0] == 0 ? -shif[1] : shif[1];
      }

      finalShift %= s.length();

      return finalShift >= 0 ?
          s.substring(s.length() - finalShift) + s.substring(0, s.length() - finalShift) :
          s.substring(-finalShift) + s.substring(0, -finalShift);
  }
}
