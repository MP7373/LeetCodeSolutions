class Solution {
  public boolean isPerfectSquare(int num) {
      if (num == 1 || num == 4) {
          return true;
      }

      long square = 0;
      var root = num / 2;
      var shift = root / 2;
      var timesPostShift = 0;

      do {
          square = (long) root * (long) root;

          if (square == num) {
              return true;
          } else if (square < num) {
              if (shift > 10)
                  root += shift;
              else {
                  root++;
                  timesPostShift++;
              }
          } else {
              if (shift > 10)
                  root -= shift;
              else {
                  root--;
                  timesPostShift++;
              }
          }

          shift /= 2;
      } while (timesPostShift < 100);

      return false;
  }
}
