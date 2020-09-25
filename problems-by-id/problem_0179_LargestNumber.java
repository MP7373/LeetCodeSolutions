class Solution {
    public String largestNumber(int[] nums) {
        var largestNumberString = IntStream.of(nums)
            .mapToObj(Integer::toString)
            .sorted((a, b) -> (b + a).compareTo(a + b))
            .collect(Collectors.joining());

        for (var c : largestNumberString.toCharArray()) {
            if (c != '0') {
                return largestNumberString;
            }
        }

        return "0";
    }
}
