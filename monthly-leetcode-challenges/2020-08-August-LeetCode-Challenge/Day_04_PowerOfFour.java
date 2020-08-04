class Solution {
    public boolean isPowerOfFour(int num) {
        for (long mask = 1L; mask < Integer.MAX_VALUE; mask <<= 2) {
            if (num == mask) {
                return true;
            }
        }

        return false;
    }
}