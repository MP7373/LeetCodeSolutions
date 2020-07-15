class Solution {
    public String reverseWords(String s) {
        var words = s.trim().split("\\s+");
        var sb = new StringBuilder();

        var first = true;
        for (var i = words.length - 1; i >= 0; i--) {
            if (first) {
                first = false;
            } else {
                sb.append(" ");
            }

            sb.append(words[i]);
        }

        return sb.toString();
    }
}
