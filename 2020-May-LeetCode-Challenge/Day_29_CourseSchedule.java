class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var map = new HashMap<Integer, Set<Integer>>();
        
        var coursesTaken = new HashSet<Integer>();
        for (var i = 0; i < numCourses; i++) {
            coursesTaken.add(i);
        }
        
        var coursesNotTaken = new HashSet<Integer>();
        for (var pair : prerequisites) {
            var course = pair[0];
            var preReq = pair[1];
            
            coursesTaken.remove(course);
            coursesNotTaken.add(course);

            if (!map.containsKey(course)) {
                var prereqs = new HashSet<Integer>();
                prereqs.add(preReq);
                
                map.put(course, prereqs);
            } else {
                map.get(course).add(preReq);
            }
        }
        
        var lastRunCoursesTaken = -1;
        
        while (lastRunCoursesTaken != coursesTaken.size()) {
            lastRunCoursesTaken = coursesTaken.size();
            
            var newNotTaken = new HashSet<Integer>();
            for (var course : coursesNotTaken) {
                if (!map.containsKey(course) || map.get(course).size() == 0) {
                    coursesTaken.add(course);
                } else {
                    var preReqs = map.get(course);
                    
                    var newReqs = new HashSet<Integer>();
                    for (var req : preReqs) {
                        if (!coursesTaken.contains(req)) {
                            newReqs.add(req);
                        }
                    }
                    
                    map.put(course, newReqs);

                    if (newReqs.size() == 0) {
                        coursesTaken.add(course);
                    } else {
                        newNotTaken.add(course);
                    }
                }
            }
            
            coursesNotTaken = newNotTaken;
        }
        
        return coursesTaken.size() == numCourses;
    }
}
