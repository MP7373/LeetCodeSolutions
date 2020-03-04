import java.util.*;

class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainVisits = new HashMap<>();
        
        for (String domain : cpdomains) {
            String[] countAndDomain = domain.split(" ");
            String[] domainParts = countAndDomain[1].split("\\.");
            
            int count = Integer.parseInt(countAndDomain[0]);

            String topLevelDomain = domainParts[domainParts.length - 1 >= 0 ? domainParts.length - 1 : 0];
            incrementMapIntegerAtKey(domainVisits, topLevelDomain, count);
            
            if (domainParts.length == 3) {
                String midDomain = domainParts[1] + "." + domainParts[2];
                incrementMapIntegerAtKey(domainVisits, midDomain, count);
            }
            
            incrementMapIntegerAtKey(domainVisits, countAndDomain[1], count);
        }
        
        List<String> visits = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainVisits.entrySet()) {
            visits.add(entry.getValue() + " " + entry.getKey());
        }
        
        return visits;
    }
    
    private static void incrementMapIntegerAtKey(Map<String, Integer> map, String key, int increment) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + increment);
        } else {
            map.put(key, increment);
        }
    }
}
