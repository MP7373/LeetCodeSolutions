class Solution {
  public int firstUniqChar(String s) {
      var encounteredChars = new HashMap<Character, CountIndexPair>();

      for (var i = 0; i < s.length(); i++) {
          var c = s.charAt(i);

          if (encounteredChars.containsKey(c)) {
              encounteredChars.get(c).count++;
          } else {
              encounteredChars.put(c, new CountIndexPair(1, i));
          }
      }

      var firstUniqueIndex = -1;
      for (var val : encounteredChars.values()) {
          if (val.count == 1) {
              if (firstUniqueIndex == -1 || val.index < firstUniqueIndex) {
                  firstUniqueIndex = val.index;
              }
          }
      }

      return firstUniqueIndex;
  }
}

class CountIndexPair {
  int count;
  int index;

  CountIndexPair(int count, int index) {
      this.count = count;
      this.index = index;
  }
}
