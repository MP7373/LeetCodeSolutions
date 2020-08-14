class Solution {
  public int longestPalindrome(String s) {
      Map<Character, Integer> charCounts = new HashMap<>();

      for (char c : s.toCharArray()) {
          charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
      }

      boolean leftOver = false;
      int maxLength = 0;
      for (char c : charCounts.keySet()) {
          int cCount = charCounts.get(c);
          if (cCount % 2 == 1) {
              leftOver = true;
              maxLength += cCount - 1;
          } else {
              maxLength += cCount;
          }
      }

      return leftOver ? maxLength + 1 : maxLength;
  }
}
