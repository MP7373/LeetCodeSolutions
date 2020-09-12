
class Solution {
  public int[][] reconstructQueue(int[][] people) {
      var map = new TreeMap<Integer, TreeSet<Integer>>();
      var inFrontMap = new HashMap<Integer, Integer>();

      for (var person : people) {
          var h = person[0];
          var tallerInFront = person[1];

          if (!map.containsKey(tallerInFront)) {
              var heights = new TreeSet<Integer>();
              heights.add(h);

              map.put(tallerInFront, heights);
          } else {
              map.get(tallerInFront).add(h);
          }

          if (!inFrontMap.containsKey(h)) {
              inFrontMap.put(h, 0);
          }
      }

      var q = new ArrayList<int[]>();

      while (q.size() < people.length) {
          var added = -1;

          for (var i = q.size(); i >= 0; i--) {
              var heights = map.get(i);

              if (heights != null) {
                  var remove = -1;
                  for (var height : heights) {
                      if (inFrontMap.get(height).equals(i)) {
                          added = height;
                          q.add(new int[] { height, i });
                          i = -1;
                          remove = height;
                          break;
                      }
                  }

                  if (remove != -1) {
                      heights.remove(remove);
                  }
              }
          }

          for (var h : inFrontMap.keySet()) {
              if (added >= h) {
                  inFrontMap.put(h, inFrontMap.get(h) + 1);
              }
          }
      }

      var result = new int[people.length][];
      for (var i = 0; i < result.length; i++) {
          result[i] = q.get(i);
      }

      return result;
  }
}
