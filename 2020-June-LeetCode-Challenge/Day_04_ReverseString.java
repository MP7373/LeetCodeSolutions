class Solution {
    public void reverseString(char[] s) {
        for (var i = 0; i < s.length / 2; i++) {
            var temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
