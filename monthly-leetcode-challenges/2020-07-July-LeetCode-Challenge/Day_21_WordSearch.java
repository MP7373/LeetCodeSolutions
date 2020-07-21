class Solution {
    public boolean exist(char[][] board, String word) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (tryGoingDirection(board, word, 0, y, x, new HashSet<>())) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int y, int x, Set<String> used) {
        return tryGoingDirection(board, word, index + 1, y - 1, x, used) ||
            tryGoingDirection(board, word, index + 1, y + 1, x, used) ||
            tryGoingDirection(board, word, index + 1, y, x - 1, used) ||
            tryGoingDirection(board, word, index + 1, y, x + 1, used);
    }

    private boolean tryGoingDirection(char[][] board, String word, int index, int y, int x, Set<String> used) {
        if (
            0 <= y && y < board.length &&
            0 <= x && x < board[0].length &&
            index < word.length() && word.charAt(index) == board[y][x]
        ) {
            String key = y + "," + x;

            if (!used.contains(key)) {
                if (index == word.length() - 1) {
                    return true;
                }

                used.add(key);
                if (dfs(board, word, index, y, x, used)) {
                    return true;
                }
                used.remove(key);
            }
        }

        return false;
    }
}
