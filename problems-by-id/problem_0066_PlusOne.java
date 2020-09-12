class Solution {
  public int[] plusOne(int[] digits) {
      var carry = 1;
      var index = digits.length - 1;
      while (carry > 0) {
          if (index < 0) {
              var newDigits = new int[digits.length + 1];
              newDigits[0] = 1;

              for (var i = 1; i < newDigits.length; i++) {
                  newDigits[i] = digits[i - 1];
              }

              return newDigits;
          } else {
              var digit = digits[index] + carry;

              if (digit > 9) {
                  carry = 1;
              } else {
                  carry = 0;
              }

              digit %= 10;
              digits[index] = digit;
              index--;
          }
      }

      return digits;
  }
}
