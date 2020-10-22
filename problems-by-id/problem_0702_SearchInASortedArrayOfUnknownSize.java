/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    private final int outOfBounds = 2147483647;

    public int search(ArrayReader reader, int target) {
        var size = 1;
        while (reader.get(size - 1) != outOfBounds) {
            size *= 2;
        }

        var len = 0;
        var left = size / 2 - 1;
        var right = size - 1;
        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (reader.get(mid) != outOfBounds && reader.get(mid + 1) == outOfBounds) {
                len = mid + 1;
                break;
            } else if (reader.get(mid) != outOfBounds) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left > right) {
            return -1;
        }

        left = 0;
        right = len - 1;
        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
