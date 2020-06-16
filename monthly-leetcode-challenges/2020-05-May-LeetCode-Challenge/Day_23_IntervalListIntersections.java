class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][];
        }

        var indexA = 0;
        var indexB = 0;
        
        var intervals = new ArrayList<Interval>();
        
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA][0] <= B[indexB][0]) {
                if (B[indexB][0] <= A[indexA][1]) {
                    var intervalStart = B[indexB][0];
                    var intervalEnd = B[indexB][0];

                    if (B[indexB][1] < A[indexA][1]) {
                        intervalEnd = B[indexB][1];
                        indexB++;
                    } else if (B[indexB][1] == A[indexA][1])  {
                        intervalEnd = B[indexB][1];
                        indexB++;
                        indexA++;
                    } else {
                        intervalEnd = A[indexA][1];
                        indexA++;
                    }

                    intervals.add(new Interval(intervalStart, intervalEnd));
                } else {
                    indexA++;
                }
            } else {
                if (A[indexA][0] <= B[indexB][1]) {
                    var intervalStart = A[indexA][0];
                    var intervalEnd = A[indexA][0];

                    if (A[indexA][1] < B[indexB][1]) {
                        intervalEnd = A[indexA][1];
                        indexA++;
                    } else if (B[indexB][1] == A[indexA][1])  {
                        intervalEnd = B[indexB][1];
                        indexB++;
                        indexA++;
                    } else {
                        intervalEnd = B[indexB][1];
                        indexB++;
                    }

                    intervals.add(new Interval(intervalStart, intervalEnd));
                } else {
                    indexB++;
                }
            }
        }
        
        var intervalArr = new int[intervals.size()][];
        
        var i = 0;
        for (var interval : intervals) {
            intervalArr[i] = new int[] { interval.start, interval.end };
            i++;
        }
        
        return intervalArr;
    }
}

class Interval {
    int start;
    int end;
    
    Interval (int s, int e) {
        start = s;
        end = e;
    }
}