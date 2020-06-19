class Solution {
    public String longestDupSubstring(String S) {
        var left = 0;
        var right = S.length();
        var longestStartIndex = -1;
        var longestEndIndex = -1;

        while (left <= right) {
            var substringLength = left + (right - left) / 2;
            
            var startIndexOfSubstring = rabinKarpGetStartIndexOfSubstring(S, substringLength);
            
            if (startIndexOfSubstring != -1) {
                longestStartIndex = startIndexOfSubstring;
                longestEndIndex = longestStartIndex + substringLength;
                
                left = substringLength + 1;
            } else {
                right = substringLength - 1;
            }
        }
        
        return longestStartIndex == -1 ? "" : S.substring(longestStartIndex, longestEndIndex);
    }
    
    private int rabinKarpGetStartIndexOfSubstring(String S, int length) {
        long hash = 0L;
        long numberOfPossibleCharacters = 256L;
        long hashModulo = Integer.MAX_VALUE;
        long maxPower = 1L;
        
        var hashesToStartIndexMap = new HashMap<Long, Integer>();
        
        for (var i = 0; i < length; i++) {
            hash = (hash * numberOfPossibleCharacters + S.charAt(i)) % hashModulo;
            if (i > 0) {
                maxPower = (maxPower * numberOfPossibleCharacters) % hashModulo;
            }
        }
        
        for (var i = 0; i + length <= S.length() && i < S.length(); i++) {
            if (
                hashesToStartIndexMap.containsKey(hash) &&
                spansMatch(i, hashesToStartIndexMap.get(hash), length, S)
            ) {
                return hashesToStartIndexMap.get(hash);
            }
            
            hashesToStartIndexMap.put(hash, i);
            
            hash = (hash - S.charAt(i) * maxPower + numberOfPossibleCharacters * hashModulo) % hashModulo;
            if (i + length < S.length()) {
                hash = (hash * numberOfPossibleCharacters + S.charAt(i + length)) % hashModulo;
            }
        }
        
        return -1;
    }
    
    private boolean spansMatch(int span1Start, int span2Start, int length, String S) {
        for (var i = 0; i < length; i++) {
            if (S.charAt(span1Start + i) != S.charAt(span2Start + i)) {
                return false;
            }
        }

        return true;
    }
}
