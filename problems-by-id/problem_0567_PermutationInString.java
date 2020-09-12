class Solution {
  public boolean checkInclusion(String s1, String s2) {
      if (s1.length() > s2.length()) {
          return false;
      }

      var s1CharCounts = new HashMap<Character, Integer>();
      for (var c : s1.toCharArray()) {
          s1CharCounts.put(c, s1CharCounts.getOrDefault(c, 0) + 1);
      }

      var charsNeededToMatch = s1CharCounts.keySet().size();
      var charsMatched = 0;
      var s2CharCounts = new HashMap<Character, Integer>();
      for (var i = 0; i < s2.length(); i++) {
          if (i >= s1.length()) {
              var firstChar = s2.charAt(i - s1.length());

              if (s2CharCounts.get(firstChar).equals(s1CharCounts.get(firstChar))) {
                  charsMatched--;
              }

              s2CharCounts.put(firstChar, s2CharCounts.get(firstChar) - 1);
          }

          var c = s2.charAt(i);
          s2CharCounts.put(c, s2CharCounts.getOrDefault(c, 0) + 1);

          if (s2CharCounts.get(c).equals(s1CharCounts.get(c))) {
              charsMatched++;
          }

          if (charsMatched == charsNeededToMatch) {
              return true;
          }
      }

      return false;
  }
}
