class Solution {

  public int largestComponentSize(int[] A) {
      UnionFind unionFind = new UnionFind(100000);

      for (int num : A) {
          int sqrtOfNumRoundedDownPlusOne = (int) (Math.sqrt(num)) + 1;

          for (int i = 2; i < sqrtOfNumRoundedDownPlusOne; i++) {
              if (num % i == 0) {
                  int factor = i;

                  unionFind.union(num, factor);
                  unionFind.union(num, num / factor);
              }
          }
      }

      Map<Integer, Integer> componentSizeMap = new HashMap<>();
      int largestComponentSize = 0;

      for (int num : A) {
          int componentId = unionFind.find(num);

          int newSizeForComponent = componentSizeMap.getOrDefault(componentId, 0) + 1;
          componentSizeMap.put(componentId, newSizeForComponent);

          largestComponentSize = Math.max(largestComponentSize, newSizeForComponent);
      }

      return largestComponentSize;
  }
}

class UnionFind {
  private final int[] groups;
  private final int[] groupSizes;

  UnionFind(int maxValue) {
      groups = new int[maxValue + 1];
      groupSizes = new int[maxValue + 1];

      for (int i = 0; i <= maxValue; i++) {
          groups[i] = i;
          groupSizes[i] = 1;
      }
  }

  int find(int value) {
      if (value == groups[value]) {
          return value;
      }

      return find(groups[value]);
  }

  int union(int value1, int value2) {
      int value1GroupId = find(value1);
      int value2GroupId = find(value2);

      if (value1GroupId == value2GroupId) {
          return value1GroupId;
      }

      if (groupSizes[value1GroupId] > groupSizes[value2GroupId]) {
          int temp = value1GroupId;
          value1GroupId = value2GroupId;
          value2GroupId = temp;
      }

      groups[value1GroupId] = value2GroupId;
      groupSizes[value2GroupId] += groupSizes[value1GroupId];

      return value2GroupId;
  }
}
