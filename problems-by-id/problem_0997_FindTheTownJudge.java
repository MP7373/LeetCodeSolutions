class Solution {
  public int findJudge(int N, int[][] trust) {
      if (N == 1) {
          return 1;
      }

      var trustMap = new HashMap<Integer, Set<Integer>>();
      var trustAnyoneSet = new HashSet<Integer>();

      for (var trustMapping : trust) {
          var trusted = trustMapping[1];
          var truster = trustMapping[0];

          trustAnyoneSet.add(truster);

          if (!trustMap.containsKey(trusted)) {
              var trusters = new HashSet<Integer>();
              trusters.add(truster);

              trustMap.put(trusted, trusters);
          } else {
              trustMap.get(trusted).add(truster);
          }
      }

      for (var key : trustMap.keySet()) {
          var trusters = trustMap.get(key);

          if (trusters.size() == N - 1 && !trustAnyoneSet.contains(key)) {
              return key;
          }
      }

      return -1;
  }
}
