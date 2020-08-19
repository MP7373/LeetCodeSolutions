class Solution {
  public String toGoatLatin(String S) {
      if (S == null || S.length() == 0) {
          return null;
      }

      int wordIndex = 1;
      StringBuilder sb = new StringBuilder();

      int i = 0;
      while (i < S.length()) {
          while (i < S.length() && !isLetter(S.charAt(i))) {
              i++;
          }

          if (wordIndex > 1) {
              sb.append(' ');
          }

          char addToEnd = '!';
          if (!isVowel(S.charAt(i))) {
              addToEnd = S.charAt(i++);
          }

          StringBuilder word = new StringBuilder();
          while (i < S.length() && isLetter(S.charAt(i))) {
              word.append(S.charAt(i));
              i++;
          }

          if (addToEnd != '!') {
              word.append(addToEnd);
          }
          word.append("ma");
          for (int j = 0; j < wordIndex; j++) {
              word.append('a');
          }

          sb.append(word.toString());
          wordIndex++;
      }

      return sb.toString();
  }

  private boolean isLetter(char c) {
      return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
  }

  private boolean isVowel(char c) {
      return c == 'a' ||
          c == 'e' ||
          c == 'i' ||
          c == 'o' ||
          c == 'u' ||
          c == 'A' ||
          c == 'E' ||
          c == 'I' ||
          c == 'O' ||
          c == 'U';
  }
}
