class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        return IntStream.range(1, 10)
            .flatMap(n -> IntStream.range(1, 11 - n)
                .map(num -> generateIncreasingDigitNumber(num, 1, n)))
            .filter(n -> low <= n && n <= high)
            .boxed()
            .collect(Collectors.toList());
    }

    private int generateIncreasingDigitNumber(int digit, int len, int maxLen) {
        return len == maxLen ?
            digit :
            generateIncreasingDigitNumber(digit * 10 + digit % 10 + 1, len + 1, maxLen);
    }
}
