class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        var charCounts = new int[26];
        for (var c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        var firstChar = s.charAt(0);
        var firstCharIndex = 0;
        var i = 0;
        while (i < s.length()) {
            var c = s.charAt(i);

            if (c < firstChar) {
                firstChar = c;
                firstCharIndex = i;
            }

            if (--charCounts[c - 'a'] == 0) {
                break;
            }

            i++;
        }

        i = firstCharIndex + 1;
        var sb = new StringBuilder();
        while (i < s.length()) {
            var c = s.charAt(i);

            if (c != firstChar) {
                sb.append(c);
            }

            i++;
        }

        return firstChar + removeDuplicateLetters(sb.toString());
    }
}
