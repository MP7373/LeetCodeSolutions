class Solution {
    public boolean backspaceCompare(String S, String T) {
        var sIndex = S.length() - 1;
        var tIndex = T.length() -1;
        
        while (sIndex >= 0 || tIndex >= 0) {
            var sSkip = 0;
            while (sIndex >= 0 && (S.charAt(sIndex) == '#' || sSkip > 0)) {
                if (S.charAt(sIndex) == '#') {
                    sSkip++;
                } else {
                    sSkip--;
                }
                sIndex--;
            }
            
            var tSkip = 0;
            while (tIndex >= 0 && (T.charAt(tIndex) == '#' || tSkip > 0)) {
                if (T.charAt(tIndex) == '#') {
                    tSkip++;
                } else {
                    tSkip--;
                }
                tIndex--;
            }
            
            if ( (sIndex < 0 && tIndex >= 0) || (tIndex < 0 && sIndex >= 0) ) {
                return false;
            }
            
            if (sIndex < 0 && tIndex < 0) {
                return true;
            }
            
            if (S.charAt(sIndex) != T.charAt(tIndex)) {
                return false;
            }
            
            sIndex--;
            tIndex--;
        }
        
        return true;
    }
}
