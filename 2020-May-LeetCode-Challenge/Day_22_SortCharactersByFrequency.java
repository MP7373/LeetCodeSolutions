class Solution {
    public String frequencySort(String s) {
        var map = new HashMap<Character, Integer>();
        var charList = new ArrayList<Character>();

        for (var c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            charList.add(c);
        }
        
        charList.sort((a, b) -> {
            var aCount = map.getOrDefault(a, 0);
            var bCount = map.getOrDefault(b, 0);
            var dif = bCount - aCount;
            
            return dif != 0 ? dif : (int) a - (int) b;
        });
        
        var sb = new StringBuilder();
        for (var c : charList) {
            sb.append(c + "");
        }
        
        return sb.toString();
    }
}