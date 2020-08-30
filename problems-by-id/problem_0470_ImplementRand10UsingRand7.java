/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {

  private final Map<String, Integer> indexMap = new HashMap<>();
  private int index = 0;
  private final int divisor = 241;

  Solution() {
      gen("", 1);
  }

  public int rand10() {
      String key = rand7() + "," + rand7() + "," + rand7() + "," + rand7();

      return indexMap.get(key) / divisor + 1;
  }

  private void gen(String combo, int digit) {
      if (digit == 4) {
          for (int i = 1; i <= 7; i++) {
              indexMap.put(combo + i, index++);
          }
          return;
      }

      for (int i = 1; i <= 7; i++) {
          gen(combo + i + ",", digit + 1);
      }
  }
}
