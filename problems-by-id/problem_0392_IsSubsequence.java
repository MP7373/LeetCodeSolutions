class Solution {
  public boolean isSubsequence(String s, String t) {
      var sIndex = 0;
      var tIndex = 0;

      while (tIndex < t.length() && sIndex < s.length()) {
          if (s.charAt(sIndex) == t.charAt(tIndex++)) {
              sIndex++;
          }
      }

      return sIndex == s.length();
  }
}
