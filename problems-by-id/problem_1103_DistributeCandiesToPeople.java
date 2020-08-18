class Solution {
  public int[] distributeCandies(int candies, int num_people) {
      int[] people = new int[num_people];
      int candiesToGive = 1;
      int index = 0;

      while (candies > 0) {
          people[index] += Math.min(candiesToGive, candies);

          candies -= candiesToGive;
          candiesToGive++;
          index++;
          if (index >= num_people) {
              index = 0;
          }
      }

      return people;
  }
}
