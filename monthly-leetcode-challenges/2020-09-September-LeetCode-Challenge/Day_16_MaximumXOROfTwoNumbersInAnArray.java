class Solution {
    public int findMaximumXOR(int[] nums) {
        return IntStream.range(-(Integer.toBinaryString(Arrays.stream(nums).max().orElse(1)).length() - 1), 1)
            .map(i -> -i)
            .reduce(0, (acc, i) -> {
                var prefixes = Arrays.stream(nums)
                        .map(num -> num >> i)
                        .boxed()
                        .collect(Collectors.toUnmodifiableSet());

                return (acc << 1) + (prefixes.stream()
                        .filter(p -> prefixes.contains( (p ^ ((acc << 1) + 1))))
                        .count() > 0 ? 1 : 0);
            });
    }
}
