class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }

        var sb = new StringBuilder();
        var i = 0;
        for (i = 0; i < 10; i++) {
            sb.append(s.charAt(i));
        }

        var repeatedSequences = new ArrayList<String>();
        var encounteredSequences = new HashSet<String>();
        var alreadyRepeated = new HashSet<String>();
        var sequence = sb.substring(i - 10);
        encounteredSequences.add(sequence);
        for (i = 10; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sequence = sb.substring(i - 9);

            if (encounteredSequences.contains(sequence) && !alreadyRepeated.contains(sequence)) {
                repeatedSequences.add(sequence);
                alreadyRepeated.add(sequence);
            } else {
                encounteredSequences.add(sequence);
            }
        }

        return repeatedSequences;
    }
}
