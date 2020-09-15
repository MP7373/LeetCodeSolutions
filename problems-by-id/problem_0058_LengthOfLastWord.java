class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int i = s.length();
        while (--i >= 0 && !isAlpha(s.charAt(i)));

        int length = 0;
        while (i >= 0 && isAlpha(s.charAt(i--))) {
            length++;
        };

        return length;
    }

    private boolean isAlpha(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}
