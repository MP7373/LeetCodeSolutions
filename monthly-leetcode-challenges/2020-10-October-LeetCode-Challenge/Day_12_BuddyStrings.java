class Solution {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        var notMatchingIndex1 = -1;
        var notMatchingIndex2 = -1;
        var aCharCounts = new int[26];
        var bCharCounts = new int[26];
        var canSwapIfEqual = false;

        for (var i = 0; i < a.length(); i++) {
            var aChar = a.charAt(i);
            var bChar = b.charAt(i);

            aCharCounts[aChar - 'a']++;
            bCharCounts[bChar - 'a']++;

            if (aChar != bChar) {
                if (notMatchingIndex1 == -1) {
                    notMatchingIndex1 = i;
                } else if (notMatchingIndex2 == -1) {
                    notMatchingIndex2 = i;
                } else {
                    return false;
                }
            }
        }

        for (var i = 0; i < 26; i++) {
            if (aCharCounts[i] > 1 && bCharCounts[i] > 1) {
                canSwapIfEqual = true;
            }
        }

        return (notMatchingIndex1 == notMatchingIndex2 && canSwapIfEqual) ||
            (notMatchingIndex1 != -1 &&
            notMatchingIndex2 != -1 &&
            b.charAt(notMatchingIndex1) == a.charAt(notMatchingIndex2) &&
            a.charAt(notMatchingIndex1) == b.charAt(notMatchingIndex2));
    }
}
