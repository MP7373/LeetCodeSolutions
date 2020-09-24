class Solution {
    public char findTheDifference(String s, String t) {
        var table = new int[26];

        for (var c : s.toCharArray()) {
            table[c - 'a']--;
        }

        for (var c : t.toCharArray()) {
            table[c - 'a']++;
        }

        for (var i = 0; i < table.length; i++) {
            if (table[i] > 0) {
                return (char) (i + 'a');
            }
        }

        return '?';
    }
}
