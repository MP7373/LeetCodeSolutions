class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);

        var l = 0;
        var r = tokens.length;
        var score = 0;

        while (l < r) {
            while (l < r && P >= tokens[l]) {
                P -= tokens[l];
                l++;
                score++;
            }

            if (l == r - 1 || l == 0) {
                break;
            }

            while (l < r - 1 && P < tokens[l] && score > 0) {
                P += tokens[r - 1];
                r--;
                score--;
            }
        }

        return score;
    }
}
