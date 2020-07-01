class Solution {
    public int arrangeCoins(int n) {
        for (long i = ((long) Math.sqrt((long) n * 2) + 1L); i >= 0; i--) {
            long stairs = (i * i + i) / 2L;
            if (stairs <= n) {
                return (int) i;
            }
        }
        
        return 0;
    }
}
