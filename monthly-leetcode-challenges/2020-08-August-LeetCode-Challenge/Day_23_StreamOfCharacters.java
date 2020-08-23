class StreamChecker {
  private final StringBuilder query = new StringBuilder();
  private final Trie trie;

  public StreamChecker(String[] words) {
      trie = Trie.buildFromStringArray(words);
  }

  public boolean query(char letter) {
      query.append(letter);

      return contains(query.length() - 1);
  }

  private boolean contains(int i) {
      char c = query.charAt(i);

      if (trie.children.containsKey(c)) {
          if (contains(trie.children.get(c), i)) {
              return true;
          }
      }

      return false;
  }

  private boolean contains(Trie t, int i) {
      if (t.c != query.charAt(i)) {
          return false;
      }

      if (t.isWordEnd) {
          return true;
      }

      if (i < 1 || (!t.children.containsKey(query.charAt(i - 1)))) {
          return false;
      }

      return contains(t.children.get(query.charAt(i - 1)), i - 1);
  }
}

class Trie {
  final char c;
  final Map<Character, Trie> children = new HashMap<>();
  boolean isWordEnd = false;

  Trie(char c) {
      this.c = c;
  }

  static Trie buildFromStringArray(String[] words) {
      Trie trie = new Trie(' ');

      Trie trieRef = trie;
      for (String word : words) {
          for (int i = word.length() - 1; i >= 0; i--) {
              char c = word.charAt(i);

              if (!trieRef.children.containsKey(c)) {
                  trieRef.children.put(c, new Trie(c));
              }

              if (i == 0) {
                  trieRef.children.get(c).isWordEnd = true;
              }

              trieRef = trieRef.children.get(c);
          }

          trieRef = trie;
      }

      return trie;
  }
}

/**
* Your StreamChecker object will be instantiated and called as such:
* StreamChecker obj = new StreamChecker(words);
* boolean param_1 = obj.query(letter);
*/
