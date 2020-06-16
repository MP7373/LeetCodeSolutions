import java.util.*;

class Solution {
  public boolean isHappy(int n) {
      Set<Integer> encounteredNumbers = new HashSet<>();

      while (n != 1) {
          int sumOfSquaredDigits = 0;
          
          while (n > 0) {
              sumOfSquaredDigits += (n % 10) * (n % 10);
              n /= 10;
          }
          
          n = sumOfSquaredDigits;
          
          if (encounteredNumbers.contains(n)) {
              break;
          }
          encounteredNumbers.add(n);
      }
      
      return n == 1;
  }
}