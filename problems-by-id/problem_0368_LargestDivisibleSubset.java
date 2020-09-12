class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
      Arrays.sort(nums);
      var tuples = new ArrayList<Tuple>();
      var max = 0;
      var maxTuple = new Tuple(1, 0, -1);

      for (var i = 0; i < nums.length; i++) {
          var n = nums[i];

          var tup = new Tuple(1, i, -1);
          for (var j = i - 1; j >= 0; j--) {
              var jTup = tuples.get(j);

              if (n % nums[j] == 0 && jTup.size + 1 >= max) {
                  max = jTup.size + 1;
                  tup = new Tuple(max, i, jTup.index);
                  maxTuple = tup;
              }
          }

          tuples.add(tup);
      }

      var list = new ArrayList<Integer>();

      while (maxTuple.previousIndex != -1) {
          list.add(nums[maxTuple.index]);
          maxTuple = tuples.get(maxTuple.previousIndex);
      }

      if (nums.length > 0) {
          list.add(nums[maxTuple.index]);
      }

      Collections.reverse(list);

      return list;
  }
}

class Tuple {
  int size;
  int index;
  int previousIndex;

  Tuple(int size, int index, int previousIndex) {
      this.size = size;
      this.index = index;
      this.previousIndex = previousIndex;
  }
}
