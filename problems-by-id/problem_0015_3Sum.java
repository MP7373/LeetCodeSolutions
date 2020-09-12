class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      var set = new HashSet<Integer>();
      var pairs = new HashSet<Integer>();
      var zeros = 0;
      for (var num : nums) {
          if (!set.contains(num)) {
              set.add(num);
          } else {
              pairs.add(num * 2);
          }

          if (num == 0) {
              zeros++;
          }
      }

      var used = new HashSet<Integer>();
      var result = new ArrayList<List<Integer>>();
      if (zeros > 2) {
          var trio = new ArrayList<Integer>();
          trio.add(0);
          trio.add(0);
          trio.add(0);
          result.add(trio);
      }

      for (var pair : pairs) {
          if (pair != 0 && set.contains(-pair)) {
              var trio = new ArrayList<Integer>();
              trio.add(pair / 2);
              trio.add(pair / 2);
              trio.add(-pair);
              result.add(trio);
          }
      }
      var keys = new HashSet<String>();


      for (var num : set) {
          if (!used.contains(num)) {
              used.add(num);

              for (var num2 : set) {
                  if (!used.contains(num2)) {
                      var third = -(num + num2);

                      if (third != num && third != num2 && set.contains(third) && !used.contains(third)) {
                          var row = new ArrayList<Integer>();
                          row.add(num);
                          row.add(num2);
                          row.add(third);
                          row.sort((a, b) -> a - b);

                          var key = row.get(0) + "," + row.get(1) + "," + row.get(2);
                          if (!keys.contains(key)) {
                              keys.add(key);

                              result.add(row);
                          }
                      }
                  }
              }
          }
      }

      return result;
  }
}
