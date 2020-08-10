class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        int multiplier = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += (s.charAt(i) - 64) * multiplier;
            multiplier *= 26;
        }
        return sum;
    }
}
