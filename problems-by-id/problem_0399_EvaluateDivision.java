class Solution {
    public double[] calcEquation(
        List<List<String>> equations,
        double[] values,
        List<List<String>> queries
    ) {
        var divides = new HashMap<String, Set<Tuple>>();
        for (var i = 0; i < values.length; i++) {
            var equation = equations.get(i);
            var divided = equation.get(0);
            var divider = equation.get(1);
            var value = values[i];

            if (!divides.containsKey(divider)) {
                divides.put(divider, new HashSet<>());
            }

            divides.get(divider).add(new Tuple(divided, value));

            if (!divides.containsKey(divided)) {
                divides.put(divided, new HashSet<>());
            }

            divides.get(divided).add(new Tuple(divider, 1 / value));
        }

        var results = new double[queries.size()];
        for (var i = 0; i < results.length; i++) {
            var query = queries.get(i);
            var divided = query.get(0);
            var divider = query.get(1);

            results[i] = findSolution(divides, new HashSet<>(), divider, divided, 1);
        }

        return results;
    }

    private double findSolution(
        HashMap<String, Set<Tuple>> divides,
        Set<String> visited,
        String divider,
        String divided,
        double multiplier
    ) {
        visited.add(divider);

        if (divides.containsKey(divided) && divider.equals(divided)) {
            return multiplier;
        }

        var numsDividerDivides = divides.get(divider);
        if (numsDividerDivides != null) {
            for (var tuple : numsDividerDivides) {
                if (!visited.contains(tuple.a)) {
                    var possibleSolution = findSolution(
                        divides,
                        visited,
                        tuple.a,
                        divided,
                        multiplier * tuple.b
                    );

                    if (possibleSolution != -1.0) {
                        return possibleSolution;
                    }
                }
            }
        }

        return -1.0;
    }
}

class Tuple {
    String a;
    double b;

    Tuple(String a, double b) {
        this.a = a;
        this.b = b;
    }

    public int hashCode() {
        return a.hashCode();
    }

    public boolean equals(Object o) {
        if (o instanceof Tuple) {
            return a.equals(((Tuple) o).a);
        }

        return false;
    }
}
