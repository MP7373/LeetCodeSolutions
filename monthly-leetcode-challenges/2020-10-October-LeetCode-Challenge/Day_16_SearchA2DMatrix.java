class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        var len = matrix.length;
        var wid = matrix[0].length;

        var l = 0;
        var r = len - 1;
        var arrayIndex = -1;
        do {
            var mid = l + (r - l) / 2;
            var midArray = matrix[mid];
            var left = midArray[0];
            var right = midArray[wid - 1];
            if (left <= target && target <= right) {
               arrayIndex = mid;
            } else if (target < left) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        } while(arrayIndex == -1 && l <= r);

        if (arrayIndex == -1) {
            return false;
        }

        var array = matrix[arrayIndex];
        l = 0;
        r = wid - 1;
        do {
            var mid = l + (r - l) / 2;
            var val = array[mid];
            if (target == val) {
                return true;
            } else if (target < val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        } while (l <= r);

        return false;
    }
}
