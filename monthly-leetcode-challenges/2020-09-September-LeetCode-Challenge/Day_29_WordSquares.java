class Solution {
    private List<List<String>> wordSquares;
    private int wordLength;
    Map<String, List<String>> prefixMap;
    LinkedList<String> possibleSquare;

    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length < 1) {
            return new ArrayList<>();
        }

        wordLength = words[0].length();
        prefixMap = createPrefixMap(words);
        wordSquares = new ArrayList<>();
        possibleSquare = new LinkedList();

        backtrack();

        return wordSquares;
    }

    private Map<String, List<String>> createPrefixMap(String[] words) {
        Map<String, List<String>> prefixMap = new HashMap<>();

        for (var word : words) {
            var sb = new StringBuilder();

            var prefix = sb.toString();
            if (!prefixMap.containsKey(prefix)) {
                prefixMap.put(prefix, new ArrayList<>());
            }

            prefixMap.get(prefix).add(word);

            for (var i = 0; i < word.length(); i++) {
                sb.append(word.charAt(i));

                prefix = sb.toString();
                if (!prefixMap.containsKey(prefix)) {
                    prefixMap.put(prefix, new ArrayList<>());
                }

                prefixMap.get(prefix).add(word);
            }
        }

        return prefixMap;
    }

    private void backtrack() {
        if (possibleSquare.size() == wordLength) {
            wordSquares.add(new ArrayList(possibleSquare));
            return;
        }

        var prefix = new StringBuilder();
        for (var word : possibleSquare) {
            prefix.append(word.charAt(possibleSquare.size()));
        }

        var wordsWithPrefix = prefixMap.get(prefix.toString());
        if (wordsWithPrefix != null) {
            for (var word : wordsWithPrefix) {
                possibleSquare.add(word);
                backtrack();
                possibleSquare.removeLast();
            }
        }
    }
}
