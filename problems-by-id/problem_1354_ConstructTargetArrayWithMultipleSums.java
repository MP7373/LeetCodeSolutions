import java.util.*;

class Solution {
  public boolean isPossible(int[] target) {
      PriorityQueue<Integer> q = new PriorityQueue<>(target.length, (a, b) -> b - a);
      int sum = 0;
      for (int i : target) {
          q.add(i);
          sum += i;
      }

      while (q.peek() > 1) {
          int n = q.poll();
          
          if (sum - n == 1) {
              return true;
          }
          
          if (sum - n == 0) {
              return false;
          }
          
          int replaceN = n % (sum - n);
          if (n == replaceN || n == 0) {
              return false;
          }

          q.add(replaceN);
          sum = sum - n + replaceN;
      }
      
      while (!q.isEmpty()) {
          System.out.println(q.peek());
          if (q.poll() != 1) {
              return false;
          }
      }

      return true;
  }
}
