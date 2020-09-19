class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        return (deck == null || deck.length < 2) ?
            false :
            Arrays.stream(deck)
                .boxed()
                .collect(
                    Collectors.groupingBy(
                        num -> num,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
                .values()
                .stream()
                .reduce(
                    (Set<Integer>) null,
                    (acc, cur) ->
                        acc == null ?
                            IntStream.range(2, cur + 1)
                                .filter(n -> cur % n == 0)
                                .boxed()
                                .collect(Collectors.toSet()) :
                            acc.stream()
                                .filter(n -> cur % n == 0)
                                .collect(Collectors.toSet()),
                    (a, b) -> a)
                .size() > 0;
    }
}
