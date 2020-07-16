class Solution {
    Map<String, Double> memo = new HashMap<>();

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n == -1) {
            return 1 / x;
        }

        String key = x + "," + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        double result = 0;
        if (n > 0 ) {
            if (n % 2 == 0) {
                result = myPow(x, n / 2) * myPow(x, n / 2);
            } else {
                result = x * myPow(x, (n - 1) / 2) * myPow(x, (n - 1) / 2);
            }
        } else {
            if (n % 2 == 0) {
                result = myPow(x, n / 2) * myPow(x, n / 2);
            } else {
                result = 1 / x * myPow(x, (n + 1) / 2) * myPow(x, (n + 1) / 2);
            }
        }

        memo.put(key, result);
        return result;
    }
}
