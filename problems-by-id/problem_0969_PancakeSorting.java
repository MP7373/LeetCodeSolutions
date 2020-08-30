class Solution {
  public List<Integer> pancakeSort(int[] A) {
      int n = A.length;

      List<Integer> result = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
          int k = 0;
          while (k < n) {
              if (A[k] == i) {
                  break;
              }
              k++;
          }

          flip(A, k);
          result.add(k + 1);

          flip(A, n - i);
          result.add(n - i + 1);
      }
      flip(A, n - 1);
      result.add(n);

      return result;
  }

  private void flip(int[] A, int k) {
      for (int i = 0; i <= k / 2; i++) {
          int temp = A[i];
          A[i] = A[k - i];
          A[k - i] = temp;
      }
  }
}
