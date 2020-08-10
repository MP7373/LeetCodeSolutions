class Solution {
    public int orangesRotting(int[][] grid) {
        int rotations = -1;
        int changes = 0;
        int freshOranges = 0;
        do {
            rotations++;
            freshOranges = 0;

            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[0].length; x++) {
                    if (grid[y][x] == 1) {
                        freshOranges++;

                        if (
                            (y - 1 >= 0 && grid[y - 1][x] == 2) ||
                            (x - 1 >= 0 && grid[y][x - 1] == 2) ||
                            (y + 1 < grid.length && grid[y + 1][x] == 2) ||
                            (x + 1 < grid[0].length && grid[y][x + 1] == 2)
                        ) {
                            grid[y][x] *= -1;
                        }
                    }
                }
            }

            changes = 0;
            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[0].length; x++) {
                    if (grid[y][x] < 0) {
                        grid[y][x] = 2;
                        changes++;
                    }
                }
            }
        } while (changes > 0);

        if (freshOranges > 0) {
            return -1;
        }

        return rotations;
    }
}
