class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie("");
        
        for (String word : words) {
            Trie trieRef = trie;
            
            for (char c : word.toCharArray()) {
                if (!trieRef.nextChars.containsKey(c)) {
                    trieRef.nextChars.put(c, new Trie(trieRef.value + c));
                }
                trieRef = trieRef.nextChars.get(c);
            }
            
            trieRef.isEnd = true;
        }
        
        List<String> foundWords = new ArrayList<>();
        
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (trie.nextChars.containsKey(board[y][x])) {
                    Set<String> visited = new HashSet<>();
                    visited.add(y + "," + x);
                    findWordsFromHere(board, trie.nextChars.get(board[y][x]), foundWords, visited, y, x);
                }
            }
        }
        
        return new ArrayList<>(new HashSet<>(foundWords));
    }
    
    private static void findWordsFromHere(char[][] board,
                              Trie trieRef,
                              List<String> foundWords,
                              Set<String> visited,
                              int y,
                              int x) {
        if (trieRef.isEnd) {
            foundWords.add(trieRef.value);
        }
        
        if (trieRef.nextChars.size() < 1) {
            return;
        }
        
        String up = (y - 1) + "," + x;
        if (
            y - 1 >= 0
            && !visited.contains(up)
            && trieRef.nextChars.containsKey(board[y - 1][x])
        ) {
            visited.add(up);
            findWordsFromHere(board, trieRef.nextChars.get(board[y - 1][x]), foundWords, visited, y - 1, x);
            visited.remove(up);
        }
        
        String down = (y + 1) + "," + x;
        if (
            y + 1 < board.length
            && !visited.contains(down)
            && trieRef.nextChars.containsKey(board[y + 1][x])
        ) {
            visited.add(down);
            findWordsFromHere(board, trieRef.nextChars.get(board[y + 1][x]), foundWords, visited, y + 1, x);
            visited.remove(down);
        }
        
        String left = y + "," + (x - 1);
        if (
            x - 1 >= 0
            && !visited.contains(left)
            && trieRef.nextChars.containsKey(board[y][x - 1])
        ) {
            visited.add(left);
            findWordsFromHere(board, trieRef.nextChars.get(board[y][x - 1]), foundWords, visited, y, x - 1);
            visited.remove(left);
        }
        
        String right = y + "," + (x + 1);
        if (
            x + 1 < board[0].length
            && !visited.contains(right)
            && trieRef.nextChars.containsKey(board[y][x + 1])
        ) {
            visited.add(right);
            findWordsFromHere(board, trieRef.nextChars.get(board[y][x + 1]), foundWords, visited, y, x + 1);
            visited.remove(right);
        }
    }
}

class Trie {
    
    String value;
    Map<Character, Trie> nextChars = new HashMap<>();
    boolean isEnd;
    
    Trie(String value) {
        this.value = value;
    }
}
