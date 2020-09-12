class Solution {
  public List<List<Integer>> subsets(int[] nums) {
      var subsets = new ArrayList<List<Integer>>();
      subsets.add(new ArrayList<Integer>());

      for (var num : nums) {
          var newSubsetLayer = new ArrayList<List<Integer>>();

          for (var subset : subsets) {
              var newSet = new ArrayList<Integer>();

              for (var n : subset) {
                  newSet.add(n);
              }

              newSet.add(num);

              newSubsetLayer.add(newSet);
          }

          for (var newSubset : newSubsetLayer) {
              subsets.add(newSubset);
          }
      }

      return subsets;
  }
}
