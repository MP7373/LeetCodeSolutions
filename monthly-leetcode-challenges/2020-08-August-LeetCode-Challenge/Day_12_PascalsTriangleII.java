class Solution {
  public List<Integer> getRow(int rowIndex) {
      List<Integer> finalRow = new ArrayList<>(rowIndex + 1);

      finalRow.add(1);
      for (int row = 1; row <= rowIndex; row++) {
          int last = 0;
          for (int i = 0; i <= row; i++) {
              if (i >= finalRow.size()) {
                  finalRow.add(last);
              } else {
                  int current = finalRow.get(i);
                  finalRow.set(i, current + last);
                  last = current;
              }
          }
      }

      return finalRow;
  }
}
