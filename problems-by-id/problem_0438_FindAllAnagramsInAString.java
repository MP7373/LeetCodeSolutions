class Solution {
  public List<Integer> findAnagrams(String s, String p) {
      if (s.length() < p.length()) {
          return new ArrayList<Integer>();
      }

      var pCharCounts = new HashMap<Character, Integer>();

      for (var c : p.toCharArray()) {
          pCharCounts.put(c, pCharCounts.getOrDefault(c, 0) + 1);
      }

      var matches = 0;
      var neededMatches = pCharCounts.keySet().size();
      var sSubstringCharCounts = new HashMap<Character, Integer>();
      var anagramStartIndexes = new ArrayList<Integer>();

      for (var i = 0; i < p.length(); i++) {
          var c = s.charAt(i);

          sSubstringCharCounts.put(c, sSubstringCharCounts.getOrDefault(c, 0) + 1);

          if ((int) sSubstringCharCounts.getOrDefault(c, 0) == (int) pCharCounts.getOrDefault(c, 0)) {
              matches++;
          } else if ((int) sSubstringCharCounts.getOrDefault(c, 0) - 1 == (int) pCharCounts.getOrDefault(c, 0)) {
              matches--;
          }

          if (matches == neededMatches) {
              anagramStartIndexes.add(i - p.length() + 1);
          }

      }

      for (var i = p.length(); i < s.length(); i++) {
          var firstChar = s.charAt(i - p.length());
          sSubstringCharCounts.put(firstChar, Math.max(sSubstringCharCounts.get(firstChar) - 1, 0));

          if (sSubstringCharCounts.getOrDefault(firstChar, 0) == pCharCounts.getOrDefault(firstChar, 0)) {
              matches++;
          } else if (sSubstringCharCounts.getOrDefault(firstChar, 0) + 1 == pCharCounts.getOrDefault(firstChar, 0)) {
              matches--;
          }

          var c = s.charAt(i);
          sSubstringCharCounts.put(c, sSubstringCharCounts.getOrDefault(c, 0) + 1);

          if ((int) sSubstringCharCounts.getOrDefault(c, 0) == (int) pCharCounts.getOrDefault(c, 0)) {
              matches++;
          } else if ((int) sSubstringCharCounts.getOrDefault(c, 0) - 1 == (int) pCharCounts.getOrDefault(c, 0)) {
              matches--;
          }

          if (matches == neededMatches) {
              anagramStartIndexes.add(i - p.length() + 1);
          }
      }

      return anagramStartIndexes;
  }
}
