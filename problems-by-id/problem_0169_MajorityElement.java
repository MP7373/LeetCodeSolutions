
class Solution {
  public int majorityElement(int[] nums) {
      var countMap = new HashMap<Integer, Integer>();

      for (var num : nums) {
          countMap.put(num, countMap.getOrDefault(num, 0) + 1);
      }

      for (var key : countMap.keySet()) {
          if (countMap.get(key) > nums.length / 2) {
              return key;
          }
      }

      return -1;
  }
}
