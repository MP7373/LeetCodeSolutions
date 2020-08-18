class Solution {
  private Set<String> used = new HashSet<>();

  public int[] numsSameConsecDiff(int N, int K) {
      if (N < 1) {
          return null;
      }

      if (N == 1) {
          return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      }

      List<Integer> nums = new ArrayList<>();

      for (int i = 0; i <= 9; i++) {
          generateSameDiffNums(nums, N, K, 0, i);
      }

      int[] sameDiffsArray = new int[nums.size()];
      for (int i = 0; i < nums.size(); i++) {
          sameDiffsArray[i] = nums.get(i);
      }

      return sameDiffsArray;
  }

  private void generateSameDiffNums(List<Integer> nums, int n, int k, int digits, int num) {
      String key = digits + "," + num;
      if (used.contains(key)) {
          return;
      }

      if (digits >= n) {
          nums.add(num);

          used.add(key);
          return;
      }

      if (digits == 1 && num == 0) {
          used.add(key);
          return;
      }

      int lastDigit = num % 10;

      int lowerKDiff = lastDigit - k;
      if (lowerKDiff >= 0) {
          generateSameDiffNums(nums, n, k, digits + 1, digits == 0 ? lowerKDiff : num * 10 + lowerKDiff);
      }

      int upperKDiff = lastDigit + k;
      if (upperKDiff < 10) {
          generateSameDiffNums(nums, n, k, digits + 1, digits == 0 ? upperKDiff : num * 10 + upperKDiff);
      }

      used.add(key);
  }
}
