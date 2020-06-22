class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        var width = dungeon[0].length;
        var height = dungeon.length;
        
        var table = new int[height][];
        for (var i = 0; i < height; i++) {
            table[i] = new int[width];
        }
        
        table[height - 1][width - 1] = Math.max(1, -dungeon[Math.max(0, height - 1)][Math.max(0, width - 1)] + 1);
        for (var y = height - 1; y >= 0; y--) {
            for (var x = width - 1; x >= 0; x--) {
                var right = Integer.MAX_VALUE;
                if (x < width - 1) {
                    right = Math.max(1, table[y][x + 1] - dungeon[y][x]);
                }
                
                var down = Integer.MAX_VALUE;
                if (y < height - 1) {
                    down = Math.max(1, table[y + 1][x] - dungeon[y][x]);
                }
                
                if (!(y == height - 1 && x == width - 1)) {
                    table[y][x] = Math.min(right, down);   
                }
            }
        }
        
        return table[0][0];
    }
}
