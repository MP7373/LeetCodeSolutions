class Solution {
  public String getHint(String secret, String guess) {
      int[] table = new int[10];

      int bulls = 0;
      int cows = 0;
      for (int i = 0; i < guess.length(); i++) {
          int s = secret.charAt(i) - '0';
          int g = guess.charAt(i) - '0';

          if (s == g) {
              bulls++;
          } else {
              if (table[s]++ < 0) {
                  cows++;
              }

              if (table[g]-- > 0) {
                  cows++;
              }
          }
      }

      return bulls + "A" + cows + "B";
  }
}
