class Solution {
  public boolean wordPattern(String pattern, String str) {
      String[] words = str.split(" ");
      if (words.length != pattern.length()) {
          return false;
      }

      Map<Character, String> letterToWordMap = new HashMap<>();
      Map<String, Character> wordToLetterMap = new HashMap<>();

      for (int i = 0; i < pattern.length(); i++) {
          char letter = pattern.charAt(i);
          String word = words[i];

          if ((letterToWordMap.containsKey(letter) && !word.equals(letterToWordMap.get(letter))) ||
             (wordToLetterMap.containsKey(word) && letter != wordToLetterMap.get(word))) {
              return false;
          }

          letterToWordMap.put(letter, word);
          wordToLetterMap.put(word, letter);
      }

      return true;
  }
}
