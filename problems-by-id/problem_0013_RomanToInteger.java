class Solution {


  public int romanToInt(String s) {
      int res = 0;
      int n = s.length();

      for (int i = n - 1; i >= 0; i--) {
          char c = s.charAt(i);

          if (c == 'I') {
              res += 1;
          } else if (c == 'V') {
              res += 5;
              if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                  res -= 1;
                  i--;
              }
          } else if (c == 'X') {
              res += 10;
              if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                  res -= 1;
                  i--;
              }
          } else if (c == 'L') {
              res += 50;
              if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                  res -= 10;
                  i--;
              }
          } else if (c == 'C') {
              res += 100;
              if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                  res -= 10;
                  i--;
              }
          } else if (c == 'D') {
              res += 500;
              if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                  res -= 100;
                  i--;
              }
          } else if (c == 'M') {
              res += 1000;
              if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                  res -= 100;
                  i--;
              }
          }
      }

      return res;
  }
}
