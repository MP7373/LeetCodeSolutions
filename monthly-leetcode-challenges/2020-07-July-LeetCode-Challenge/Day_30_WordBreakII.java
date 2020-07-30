class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = buildTrieFromWordList(wordDict);

        return buildSentencesFromTrie(new HashMap<>(), root, root, " " + s, 0);
    }
    
    private TrieNode buildTrieFromWordList(List<String> words) {
        TrieNode root = new TrieNode(' ', false);

        for (String word : words) {
            TrieNode trie = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!trie.children.containsKey(c)) {
                    trie.children.put(c, new TrieNode(c, i == word.length() - 1));
                } else if (i == word.length() - 1) {
                    trie.children.get(c).isWordEnd = true;
                }
                
                trie = trie.children.get(c);
            }
        }
        
        return root;
    }
    
    private List<String> buildSentencesFromTrie(
        Map<String, List<String>> memo,
        TrieNode root,
        TrieNode trie,
        String s,
        int index
    ) {
        String key = trie.id + "," + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (index == s.length() - 1) {
            List<String> res = new ArrayList<>();
            if (trie.isWordEnd) {
                res.add("");
            }
            return res;
        }

        
        List<String> sentences = new ArrayList<>();
        char c = s.charAt(index + 1);
        if (trie.children.containsKey(c)) {
            buildSentencesFromTrie(memo, root, trie.children.get(c), s, index + 1)
                .forEach(sentence -> sentences.add(c + sentence));
        }
        
        if (trie.isWordEnd && root.children.containsKey(c)) {
            buildSentencesFromTrie(memo, root, root.children.get(c), s, index + 1)
                .forEach(sentence -> sentences.add(" " + c + sentence));
        }
        
        memo.put(key, sentences);
        return sentences;
    }
}

class TrieNode {
    private static int globalId = 0;
    char character;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWordEnd;
    int id;
    
    TrieNode(char c, boolean isWordEnd) {
        character = c;
        this.isWordEnd = isWordEnd;
        id = globalId++;
    }
}
