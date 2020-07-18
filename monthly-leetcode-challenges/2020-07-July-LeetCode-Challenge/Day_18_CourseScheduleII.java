class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
      Map<Integer, Course> courses = new HashMap<>();

      for (int i = 0; i < numCourses; i++) {
          if (!courses.containsKey(i)) {
              Course c = new Course(i);
              courses.put(i, c);
          }
      }

      for (int[] preReqMapping : prerequisites) {
          if (!courses.containsKey(preReqMapping[0])) {
              Course c = new Course(preReqMapping[0], preReqMapping[1]);
              courses.put(preReqMapping[0], c);
          } else {
              Course c = courses.get(preReqMapping[0]);
              c.prereqs.add(preReqMapping[1]);
          }

          if (!courses.containsKey(preReqMapping[1])) {
              Course c = new Course(preReqMapping[1]);
              courses.put(preReqMapping[1], c);
          }
      }

      Set<Integer> takenCourses = new HashSet<>();
      List<Course> remainingCourses = new ArrayList(courses.values());
      int[] result = new int[numCourses];
      int resultIndex = 0;
      boolean go = true;
      while (remainingCourses.size() > 0 && go) {
          go = false;
          List<Course> nextCourses = new ArrayList<>();

          for (Course c : remainingCourses) {
              Set<Integer> preReqs = new HashSet<>(c.prereqs);
              for (int pre : preReqs) {
                  if (takenCourses.contains(pre)) {
                      c.prereqs.remove(pre);
                  }
              }

              if (c.prereqs.size() == 0) {
                  takenCourses.add(c.id);
                  result[resultIndex++] = c.id;
                  go = true;
              } else {
                  nextCourses.add(c);
              }
          }

          remainingCourses = nextCourses;
      }

      if (remainingCourses.size() > 0) {
          return new int[] {};
      }

      return result;
  }
}

class Course {
  int id;
  Set<Integer> prereqs;

  Course(int i) {
      id = i;
      prereqs = new HashSet<>();
  }

  Course(int i, int p) {
      id = i;
      prereqs = new HashSet<>();
      prereqs.add(p);
  }
}
