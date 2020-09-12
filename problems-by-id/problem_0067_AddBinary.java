class Solution {
  public String addBinary(String a, String b) {
      StringBuilder sb = new StringBuilder();

      int carry = 0;
      for (int i = 0; a.length() - 1 - i >= 0 || b.length() - 1 - i >= 0 || carry == 1; i++) {
          int aBit = 0;
          int aIndex = a.length() - 1 - i;
          if (aIndex >= 0 && a.charAt(aIndex) == '1') {
              aBit = 1;
          }

          int bBit = 0;
          int bIndex = b.length() - 1 - i;
          if (bIndex >= 0 && b.charAt(bIndex) == '1') {
              bBit = 1;
          }

          int sum = aBit + bBit + carry;
          switch (sum) {
              case 0:
                  sb.append('0');
                  carry = 0;
                  break;
              case 1:
                  sb.append('1');
                  carry = 0;
                  break;
              case 2:
                  sb.append('0');
                  carry = 1;
                  break;
              case 3:
                  sb.append('1');
                  carry = 1;
                  break;
          }
      }

      return sb.reverse().toString();
  }
}
