class Solution {
    public double champagneTower(int poured, int queryRow, int queryGlass) {
        var lastRow = new double[1];
        lastRow[0] = poured;

        for (var i = 0; i < queryRow; i++) {
            var nextRow = new double[i + 2];
            nextRow[0] = Math.max((lastRow[0] - 1) / 2, 0);

            for (var j = 1; j < i + 1; j++) {
                var remainingLiquidFromLeft = lastRow[j - 1] - 1;
                var halfOfRemainingLiquidFromLeft = Math.max(remainingLiquidFromLeft / 2, 0);

                var remainingLiquidFromRight = lastRow[j] - 1;
                var halfOfRemainingLiquidFromRight = Math.max(remainingLiquidFromRight / 2, 0);

                nextRow[j] = halfOfRemainingLiquidFromLeft + halfOfRemainingLiquidFromRight;
            }

            nextRow[i + 1] = Math.max((lastRow[i] - 1) / 2, 0);

            lastRow = nextRow;
        }

        if (lastRow[queryGlass] >= 1) {
            return 1;
        }

        return lastRow[queryGlass];
    }
}
