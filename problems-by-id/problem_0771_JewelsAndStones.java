class Solution {
  public int numJewelsInStones(String J, String S) {
      var jewels = new HashSet<Character>();

      for (var c : J.toCharArray()) {
          jewels.add(c);
      }

      var numberOfJewels = 0;
      for (var c : S.toCharArray()) {
          if (jewels.contains(c)) {
              numberOfJewels++;
          }
      }

      return numberOfJewels;
  }
}
