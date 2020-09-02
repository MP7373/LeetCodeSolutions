class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
      List<NumIndex> numIndexes = new ArrayList<>();

      for (int i = 0; i < nums.length; i++) {
          numIndexes.add(new NumIndex(nums[i], i));
      }

      numIndexes.sort((a, b) -> {
          int d = a.num - b.num;

          if (d != 0) {
              return d;
          }

          return a.index - b.index;
      });

      int l = 0;
      int r = 1;

      while (r < numIndexes.size()) {
          NumIndex ln = numIndexes.get(l);
          NumIndex rn = numIndexes.get(r);

          long dist = (long) Math.abs((long) rn.num - ln.num);
          if (dist <= (long) t) {
              int indexDist = (int) Math.abs(rn.index - ln.index);

              if (indexDist <= k) {
                  return true;
              }
          }

          if (l < r - 1) {
              l++;
          } else {
              if (++r >= numIndexes.size()) {
                  break;
              }

              rn = numIndexes.get(r);
              dist = (long) Math.abs((long) rn.num - ln.num);
              while (l > 0 && dist <= (long) t) {
                  l--;

                  ln = numIndexes.get(l);
                  dist = (long) Math.abs((long) rn.num - ln.num);
              }
          }
      }

      return false;
  }
}

class NumIndex {
  int num;
  int index;

  NumIndex(int n, int i) {
      num = n;
      index = i;
  }
}
