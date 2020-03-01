import java.util.*;

class Solution {
    
  public List<String> wordBreak(String s, List<String> wordDict) {
      return wordBreak(s, new HashSet<>(wordDict), new HashMap<>(), 0);
  }
  
  public static List<String> wordBreak(
      String s,
      Set<String> wordDict,
      Map<Integer, List<String>> memo,
      int index
  ) {
      if (memo.containsKey(index)) {
          return memo.get(index);
      }
      
      List<String> wordBreaks = new ArrayList<>();
      
      if (index >= s.length()) {
          wordBreaks.add("");
      }

      for (int i = index + 1; i <= s.length(); i++) {
          String currentWord = s.substring(index, i);
          if (wordDict.contains(currentWord)) {
              for (String wordBreak : wordBreak(s, wordDict, memo, i)) {
                  if (wordBreak.equals("")) {
                      wordBreaks.add(currentWord);
                  } else {
                      wordBreaks.add(currentWord + " " + wordBreak);   
                  }
              }
          }
      }
      
      memo.put(index, wordBreaks);

      return wordBreaks;
  }
}
