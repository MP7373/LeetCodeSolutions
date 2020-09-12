class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
      var memo = new int[text1.length() + 1][text2.length() + 1];

      for (var y = text1.length() - 1; y >= 0; y--) {
          for (var x = text2.length() -  1; x >= 0; x--) {
              if (text1.charAt(y) == text2.charAt(x)) {
                  memo[y][x] = memo[y + 1][x + 1] + 1;
              } else {
                  memo[y][x] = Math.max(memo[y + 1][x], memo[y][x + 1]);
              }
          }
      }

      return memo[0][0];
  }
}
