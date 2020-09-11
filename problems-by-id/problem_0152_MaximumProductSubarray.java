class Solution {
  public int maxProduct(int[] nums) {
      if (nums == null || nums.length < 1) {
          return 0;
      }

      var max = nums[0];

      var oppositeSignProduct = 0;
      var runningProduct = 0;
      var lastWasNegative = false;
      for (var num : nums) {
          if (num != 0) {
              if (oppositeSignProduct == 0 && lastWasNegative) {
                  oppositeSignProduct = 1;
              }

              if (runningProduct == 0) {
                  runningProduct = 1;
              }

              runningProduct *= num;

              if (oppositeSignProduct != 0) {
                  oppositeSignProduct *= num;

                  max = Math.max(max, Math.max(runningProduct, oppositeSignProduct));
              } else {
                  max = Math.max(max, runningProduct);
              }
          } else {
              oppositeSignProduct = 0;
              runningProduct = 0;
              if (0 > max) {
                  max = 0;
              }
          }

          lastWasNegative = num < 0;
      }

      return max;
  }
}
