class Solution {
  public String addStrings(String num1, String num2) {
      var len = Math.max(num1.length(), num2.length());
      
      var total = "";
      var carry = 0;
      for (var i = 0; i < len; i++) {
          var digit1 = 0;
          if (num1.length() - 1 - i >= 0) {
              digit1 += Integer.parseInt("" + num1.charAt(num1.length() - 1 - i));
          }

          var digit2 = 0;
          if (num2.length() - 1 - i >= 0) {
              digit2 += Integer.parseInt("" + num2.charAt(num2.length() - 1 - i));
          }
          
          var digit = digit1 + digit2 + carry;
          
          if (digit > 9) {
              digit %= 10;
              carry = 1;
          } else {
              carry = 0;
          }

          total = digit + total;
      }
      
      if (carry > 0) {
          total = carry + total;
      }
      
      return total;
  }
}
