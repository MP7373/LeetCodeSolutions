/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        var xYMaxes = binaryMatrix.dimensions();
        var xMax = xYMaxes.get(1);
        var yMax = xYMaxes.get(0);

        var leftMostColumn = xMax - 1;
        var noOnesFound = true;
        
        for (var y = 0; y < yMax; y++) {
            var val = binaryMatrix.get(y, leftMostColumn);

            if (val == 1) {
                noOnesFound = false;

                while (val == 1) {
                    leftMostColumn--;

                    if (leftMostColumn < 0) {
                        break;
                    }

                    val = binaryMatrix.get(y, leftMostColumn);
                }

                leftMostColumn++;
            }
        }
        
        return noOnesFound ? -1 : leftMostColumn;
    }
}
