class WordDictionary {
    private Trie root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie(' ', false);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie trie = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!trie.children.containsKey(c)) {
                trie.children.put(c, new Trie(c, i == word.length() - 1));
            } else if (i == word.length() - 1) {
                trie.children.get(c).isWordEnd = true;
            }

            trie = trie.children.get(c);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, Trie trie) {
        if (word == null || trie == null) {
            return false;
        }

        if (index >= word.length()) {
            return trie.isWordEnd;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (Character nextChar : trie.children.keySet()) {
                if (search(word, index + 1, trie.children.get(nextChar))) {
                    return true;
                }
            }

            return false;
        }

        if (!trie.children.containsKey(c)) {
            return false;
        }

        return search(word, index + 1, trie.children.get(c));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class Trie {
    char c;
    boolean isWordEnd;
    Map<Character, Trie> children = new HashMap<>();

    Trie(char c, boolean isWordEnd) {
        this.c = c;
        this.isWordEnd = isWordEnd;
    }
}