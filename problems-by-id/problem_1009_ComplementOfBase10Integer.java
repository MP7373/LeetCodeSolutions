class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }

        var complement = 0;

        var mask = 1;
        while (mask * 2 > mask) {
            mask *= 2;
        }

        while (mask > 0 && ((mask & N) == 0)) {
            mask /= 2;
        }

        while (mask > 0) {
            if ((mask & N) == 0) {
                complement++;
            }

            if (mask > 1) {
                complement = complement << 1;
            }

            mask /= 2;
        }

        return complement;
    }
}
