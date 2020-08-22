class Solution {
  public int[] sortArrayByParity(int[] A) {
      int left = 0;
      int right = A.length - 1;
      
      while (left < right) {
          while (left < right && A[left] % 2 == 0) {
              left++;
          }
          
          while (left < right && A[right] % 2 == 1) {
              right--;
          }
          
          int temp = A[left];
          A[left] = A[right];
          A[right] = temp;
      }
      
      return A;
  }
}
