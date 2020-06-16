class Solution {

  public String convert(String s, int numRows) {
      if (numRows == 1) return s;

      String[] zig = new String[numRows];
      for (int i = 0; i < numRows; i++) zig[i] = "";
      
      int y = 0;
      boolean goingDown = true;
      for (int i = 0; i < s.length(); i++) {
          if (goingDown) {
              zig[y] += s.charAt(i);
              if (y >= numRows - 1) {
                  goingDown = false;
                  y--;
              } else {
                  y++;
              }
          } else {
             for (int j = 0; j < zig.length; j++) {
                 if (j != y) {
                      zig[j] += " ";
                 }
             }
             zig[y] += s.charAt(i);
              
              if (y <= 0) {
                  goingDown = true;
                  y++;
              } else {
                  y--;
              }
          }
      }
      
      String zigZagString = "";
      for (int i = 0; i < zig.length; i++) {
          for (char c : zig[i].toCharArray()) {
              if (c != ' ') {
                  zigZagString += c;
              }
          }
      }
      
      return zigZagString;
  }
}
