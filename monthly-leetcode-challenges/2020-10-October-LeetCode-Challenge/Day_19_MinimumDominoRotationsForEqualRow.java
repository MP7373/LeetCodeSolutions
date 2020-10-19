class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        var counts = new int[6];
        var aCounts = new int[6];
        var bCounts = new int[6];

        for (var number = 1; number <= 6; number++) {
            var count = 0;
            var topCount = 0;
            var bottomCount = 0;

            for (var i = 0; i < A.length; i++) {
                if (A[i] == number || B[i] == number) {
                    if (A[i] == number) {
                        topCount++;
                    }

                    if (B[i] == number) {
                        bottomCount++;
                    }

                    count++;
                }
            }

            if (count == A.length) {
                return Math.min(A.length - topCount, A.length - bottomCount);
            }
        }

        return -1;
    }
}
