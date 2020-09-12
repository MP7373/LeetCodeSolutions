class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
      var noteCharMap = makeCharCountMapFromString(ransomNote);
      var magazineCharMap = makeCharCountMapFromString(magazine);

      for (var c : noteCharMap.keySet()) {
          if (magazineCharMap.getOrDefault(c, 0) < noteCharMap.get(c)) {
              return false;
          }
      }

      return true;
  }

  private HashMap<Character, Integer> makeCharCountMapFromString(String s) {
      var map = new HashMap<Character, Integer>();

      for (var c : s.toCharArray()) {
          map.put(c, map.getOrDefault(c, 0) + 1);
      }

      return map;
  }
}
