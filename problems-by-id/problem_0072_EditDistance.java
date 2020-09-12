class Solution {
  public int minDistance(String word1, String word2) {
      var table = new int[word1.length() + 1][];

      for (var i = 0; i <= word1.length(); i++) {
          table[i] = new int[word2.length() + 1];
      }

      for (var i = 1; i <= word1.length(); i++) {
          table[i][0] = i;
      }

      for (var i = 1; i <= word2.length(); i++) {
          table[0][i] = i;
      }

      for (var i = 1; i <= word1.length(); i++) {
          var c1 = word1.charAt(i - 1);

          for (var j = 1; j <= word2.length(); j++) {
              var c2 = word2.charAt(j - 1);

              if (c1 == c2) {
                  table[i][j] = Math.min(table[i - 1][j - 1], Math.min(table[i - 1][j], table[i][j - 1]) + 1);
              } else {
                  table[i][j] = Math.min(table[i - 1][j - 1], Math.min(table[i - 1][j], table[i][j - 1])) + 1;
              }
          }
      }

      return table[word1.length()][word2.length()];
  }
}
