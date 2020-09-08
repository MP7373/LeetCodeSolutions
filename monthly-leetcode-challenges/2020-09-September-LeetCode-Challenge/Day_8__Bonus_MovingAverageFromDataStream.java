class MovingAverage {
  private final int maxSize;
  private final ArrayDeque<Integer> q = new ArrayDeque<>();
  private double sum = 0;

  /** Initialize your data structure here. */
  public MovingAverage(int size) {
      maxSize = size;
  }

  public double next(int val) {
      sum += val;

      q.add(val);
      if (q.size() > maxSize) {
          sum -= q.pollFirst();
      }

      return sum / q.size();
  }
}

/**
* Your MovingAverage object will be instantiated and called as such:
* MovingAverage obj = new MovingAverage(size);
* double param_1 = obj.next(val);
*/
