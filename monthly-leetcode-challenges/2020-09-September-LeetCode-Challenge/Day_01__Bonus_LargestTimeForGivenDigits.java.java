class Solution {
  public String largestTimeFromDigits(int[] A) {
      StringBuilder sb = new StringBuilder();

      Map<Integer, Integer> numCounts = new HashMap<>();

      int numsLessThan4 = 0;
      int numsLessThan6 = 0;

      for (int num : A) {
          numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);

          if (num < 4) {
              numsLessThan4++;
          }

          if (num < 6) {
              numsLessThan6++;
          }
      }

      if (numsLessThan4 < 1 || numsLessThan6 < 2) {
          return "";
      }

      boolean firstDigit2 = false;
      for (int i = 2; i >= 0; i--) {
          if (numCounts.containsKey(i) && !(
              i == 2 && (numsLessThan4 < 2 || numsLessThan6 < 3)
          )) {
              sb.append(i);

              if (numCounts.get(i) > 1) {
                  numCounts.put(i, numCounts.get(i) - 1);
              } else {
                  numCounts.remove(i);
              }

              if (i == 2) {
                  firstDigit2 = true;
              }

              break;
          }

          if (i == 0) {
              return "";
          }
      }

      int i = 10;
      if (firstDigit2) {
          i = 4;
      }

      while (i-- > 0) {
          if (numCounts.containsKey(i)) {
              sb.append(i);

              if (numCounts.get(i) > 1) {
                  numCounts.put(i, numCounts.get(i) - 1);
              } else {
                  numCounts.remove(i);
              }

              break;
          }

          if (i == 0) {
              return "";
          }
      }

      sb.append(':');

      i = 6;
      while (i-- > 0) {
          if (numCounts.containsKey(i)) {
              sb.append(i);

              if (numCounts.get(i) > 1) {
                  numCounts.put(i, numCounts.get(i) - 1);
              } else {
                  numCounts.remove(i);
              }

              break;
          }

          if (i == 0) {
              return "";
          }
      }

      i = 10;
      while (i-- > 0) {
          if (numCounts.containsKey(i)) {
              sb.append(i);

              break;
          }

          if (i == 0) {
              return "";
          }
      }

      return sb.toString();
  }
}
