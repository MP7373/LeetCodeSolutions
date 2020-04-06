import java.util.*;
import java.util.stream.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var groups = new HashMap<String, List<String>>();
        
        for (var s : strs) {
            var sSorted = s.chars()
                .sorted()
                .mapToObj(c -> ((char) c))
                .map(Object::toString)
                .collect(Collectors.joining());
            
            if (groups.containsKey(sSorted)) {
                groups.get(sSorted).add(s);
            } else {
                var newList = new ArrayList<String>();
                newList.add(s);

                groups.put(sSorted, newList);
            }
        }
        
        return new ArrayList<>(groups.values());
    }
}
