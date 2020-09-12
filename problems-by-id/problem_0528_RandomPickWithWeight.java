class Solution {

  private final int[] w;
  private final int sum;

  public Solution(int[] w) {
      this.w = w;
      sum = Arrays.stream(w).sum();
  }

  public int pickIndex() {
      double rand = Math.random() * sum;
      var positionSum = 0;
      for (var i = 0; i < w.length; i++) {
          positionSum += w[i];
          if (rand <= positionSum) {
              return i;
          }
      }
      return 0;
  }
}

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(w);
* int param_1 = obj.pickIndex();
*/
