class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);

        int n = citations.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, Math.min(n - i, citations[i]));
        }

        return max;
    }
}
