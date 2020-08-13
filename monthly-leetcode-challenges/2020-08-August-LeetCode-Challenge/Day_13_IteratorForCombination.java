class CombinationIterator {
  private List<String> combinations = null;
  private int combinationIndex = 0;

  public CombinationIterator(String characters, int combinationLength) {
      combinations = new ArrayList<>();
      generateCombinations(
          combinations,
          characters,
          0,
          combinationLength,
          0,
          new StringBuilder()
      );
  }

  public String next() {
      if (hasNext()) {
          return combinations.get(combinationIndex++);
      }

      return null;
  }

  public boolean hasNext() {
      return combinations != null && combinationIndex < combinations.size();
  }

  private void generateCombinations(
      List<String> list,
      String characters,
      int charIndex,
      int combinationLength,
      int index,
      StringBuilder sb
  ) {
      if (index == combinationLength) {
          list.add(sb.toString());

          return;
      }

      for (int i = charIndex; i < characters.length(); i++) {
          char c = characters.charAt(i);

          sb.append(c);
          generateCombinations(list, characters, i + 1, combinationLength, index + 1, sb);
          sb.deleteCharAt(sb.length() - 1);
      }
  }
}
