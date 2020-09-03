class Solution {
  public boolean repeatedSubstringPattern(String s) {
      int len = s.length();

      for (int l = 1; l < len / 2 + 1; l++) {
          if (len % l == 0) {
              for (int i = 0; i < len; i++) {
                  int innerIndex = i % l;

                  if (s.charAt(i) != s.charAt(innerIndex)) {
                      break;
                  }

                  if (i == len - 1) {
                      return true;
                  }
              }
          }
      }

      return false;
  }
}
