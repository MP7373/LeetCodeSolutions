class Solution {
  public int[] findPermutation(String s) {
      int num = 1;
      int[] permutation = new int[s.length() + 1];
      int permIndex = 0;

      int decreasingRun = 0;
      for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == 'I') {
              if (decreasingRun > 0) {
                  for (int n = num + decreasingRun; n > num; n--) {
                      permutation[permIndex++] = n;
                  }
              }
              permutation[permIndex++] = num;
              num += 1 + decreasingRun;
              decreasingRun = 0;
          } else {
              decreasingRun++;
          }
      }

      if (decreasingRun > 0) {
          for (int n = num + decreasingRun; n > num; n--) {
              permutation[permIndex++] = n;
          }
      }
      permutation[permIndex++] = num;
      num += 1 + decreasingRun;

      return permutation;
  }
}
