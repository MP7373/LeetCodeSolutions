import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        int level = 0;
        Set<Integer> skip = new HashSet<>();
        
        int start = 0;
        do {
            level = 0;
            boolean found = false;
            int open = start;
            for (int i = start; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    level++;
                    if (!found) {
                        found = true;
                        open = i;
                    }
                } else if (c == ')') {
                    level--;
                    if (level < 0) {
                        skip.add(i);
                        level++;
                    }
                    
                    if (level == 0) {
                        found = false;
                    }
                }
            }
            
            if (level > 0) {
                skip.add(open);
                start = open + 1;
            }
        } while (level > 0);
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!skip.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
