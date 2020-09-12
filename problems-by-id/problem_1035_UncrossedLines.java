class Solution {
  private Map<String, Integer> memo = new HashMap<>();
  private int[] A;
  private int[] B;
  private Map<Integer, Integer> mapA;
  private Map<Integer, Integer> mapB;

  public int maxUncrossedLines(int[] A, int[] B) {
      this.A = A;
      this.B = B;
      mapA = createValMap(A);
      mapB = createValMap(B);

      return check(0, 0);
  }

  private int check(int indexA, int indexB) {
      if (indexA >= A.length || indexB >= B.length) {
          return 0;
      }

      var key = indexA + "," + indexB;
      if (memo.containsKey(key)) {
          return memo.get(key);
      }

      mapA.put(A[indexA], mapA.get(A[indexA]) - 1);
      mapB.put(B[indexB], mapB.get(B[indexB]) - 1);

      var skipBothResult = check(indexA + 1, indexB + 1);

      mapA.put(A[indexA], mapA.get(A[indexA]) + 1);
      mapB.put(B[indexB], mapB.get(B[indexB]) + 1);

      if (A[indexA] == B[indexB]) {
          mapA.put(A[indexA], mapA.get(A[indexA]) - 1);
          mapB.put(B[indexB], mapB.get(B[indexB]) - 1);

          var result = check(indexA + 1, indexB + 1) + 1;

          mapA.put(A[indexA], mapA.get(A[indexA]) + 1);
          mapB.put(B[indexB], mapB.get(B[indexB]) + 1);

          result = Math.max(result, skipBothResult);
          memo.put(key, result);
          return result;
      }

      if (mapB.getOrDefault(A[indexA], 0) > 0 && mapA.getOrDefault(B[indexB], 0) > 0) {
          // match a index to first in b
          mapA.put(A[indexA], mapA.get(A[indexA]) - 1);

          var i = indexB;
          for (; B[i] != A[indexA]; i++) {
              mapB.put(B[i], mapB.get(B[i]) - 1);
          }
          mapB.put(B[i], mapB.get(B[i]) - 1);

          var aMatchResult = check(indexA + 1, i + 1) + 1;

          for (; i >= indexB; i--) {
              mapB.put(B[i], mapB.get(B[i]) + 1);
          }

          mapA.put(A[indexA], mapA.get(A[indexA]) + 1);

          // match b index to first in a
          mapB.put(B[indexB], mapB.get(B[indexB]) - 1);

          i = indexA;
          for (; A[i] != B[indexB]; i++) {
              mapA.put(A[i], mapA.get(A[i]) - 1);
          }
          mapA.put(A[i], mapA.get(A[i]) - 1);

          var bMatchResult = check(i + 1, indexB + 1) + 1;

          for (; i >= indexA; i--) {
              mapA.put(A[i], mapA.get(A[i]) + 1);
          }

          mapB.put(B[indexB], mapB.get(B[indexB]) + 1);

          var result = Math.max(aMatchResult, bMatchResult);
          result = Math.max(result, skipBothResult);
          memo.put(key, result);

          return result;
      }

      if (mapA.getOrDefault(B[indexB], 0) <= 0) {
          mapB.put(B[indexB], mapB.get(B[indexB]) - 1);

          var result = check(indexA, indexB + 1);
          result = Math.max(result, skipBothResult);
          memo.put(key, result);

          mapB.put(B[indexB], mapB.get(B[indexB]) + 1);

          return result;
      }

      mapA.put(A[indexA], mapA.get(A[indexA]) - 1);

      var result = check(indexA + 1, indexB);
      result = Math.max(result, skipBothResult);
      memo.put(key, result);

      mapA.put(A[indexA], mapA.get(A[indexA]) + 1);

      return result;
  }

  private Map<Integer, Integer> createValMap(int[] arr) {
      var valMap = new HashMap<Integer, Integer>();

      for (var n : arr) {
          valMap.put(n, valMap.getOrDefault(n, 0) + 1);
      }

      return valMap;
  }
}
