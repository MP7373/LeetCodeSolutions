class Trie {
    
  Node root;

  /** Initialize your data structure here. */
  public Trie() {
      root = new Node(' ');
  }
  
  /** Inserts a word into the trie. */
  public void insert(String word) {
      var node = root;

      for (var c : word.toCharArray()) {
          if (!node.next.containsKey(c)) {
              node.next.put(c, new Node(c));
          }
          
          node = node.next.get(c);
      }
      
      node.isWordEnd = true;
  }
  
  /** Returns if the word is in the trie. */
  public boolean search(String word) {
      var node = root;

      for (var c : word.toCharArray()) {
          if (!node.next.containsKey(c)) {
              return false;
          }
          
          node = node.next.get(c);
      }
      
      return node.isWordEnd;
  }
  
  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
      var node = root;

      for (var c : prefix.toCharArray()) {
          if (!node.next.containsKey(c)) {
              return false;
          }
          
          node = node.next.get(c);
      }
      
      return true;
  }
}

class Node {
  Map<Character, Node> next;
  char letter;
  boolean isWordEnd = false;
  
  Node(char l) {
      letter = l;
      next = new HashMap<>();
  }
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/