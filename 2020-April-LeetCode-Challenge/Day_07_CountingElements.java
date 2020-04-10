import java.util.*;
import java.util.stream.Collectors;

class Solution {
  public int countElements(int[] arr) {
      var set = Arrays.stream(arr)
          .mapToObj(Integer::valueOf)
          .collect(Collectors.toSet());
      var result = 0;
      
      for (var number : arr) {
          if (set.contains(number + 1)) {
              result++;
          }
      }
      
      return result;
  }
}
