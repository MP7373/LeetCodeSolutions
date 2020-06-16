class Solution {
  public boolean checkValidString(String s) {
      return checkValidString(s, 0);
  }
  
  public boolean checkValidString(String s, int stack) {        
      for (var i = 0; i < s.length(); i++) {
          var c = s.charAt(i);

          if (c == '(') {
              stack++;
          } else if (c == ')') {
              stack--;
              
              if (stack < 0) {
                  return false;
              }
          } else {
              return  checkValidString("(" + s.substring(i + 1), stack) ||
                  checkValidString(")" + s.substring(i + 1), stack) ||
                  checkValidString(s.substring(i + 1), stack);
          }
      }
      
      return stack == 0;
  }
}
