class Solution {
  public String intToRoman(int num) {        
      return makeRoman(num / 1000, 4) +
          makeRoman(num % 1000 / 100, 3) +
          makeRoman(num % 100 / 10, 2) +
          makeRoman(num % 10, 1);
  }
  
  private String makeRoman(int value, int digit) {
      var oneDigit = switch (digit) {
          case 1 -> "I";
          case 2 -> "X";
          case 3 -> "C";
          case 4 -> "M";
          default -> "";
      };
      
      var fiveDigit = switch (digit) {
          case 1 -> "V";
          case 2 -> "L";
          case 3 -> "D";
          default -> "";
      };
      
      var nextDigit = switch (digit) {
          case 1 -> "X";
          case 2 -> "C";
          case 3 -> "M";
          default -> "";
      };
      
      return switch (value) {
          case 1 -> oneDigit;
          case 2 -> oneDigit + oneDigit;
          case 3 -> oneDigit + oneDigit + oneDigit;
          case 4 -> oneDigit + fiveDigit;
          case 5 -> fiveDigit;
          case 6 -> fiveDigit + oneDigit;
          case 7 -> fiveDigit + oneDigit + oneDigit;
          case 8 -> fiveDigit + oneDigit + oneDigit + oneDigit;
          case 9 -> oneDigit + nextDigit;
          default -> "";
      };
  }
}