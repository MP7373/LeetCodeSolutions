import java.util.*;

class Solution {

    public int cherryPickup(int[][] grid) {
        int[][][] memo = new int[grid.length][grid.length][grid.length];
        
        for (int[][] matrix : memo) {
            for (int[] row : matrix) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        
        return Math.max(0, dp(grid, memo, 0, 0, 0));
    }
    
    private static int dp(int[][] grid, int[][][] memo, int person1Row, int person1Column, int person2Column) {
        int person2Row = person1Row + person1Column - person2Column;
        
        boolean outOfBounds = person1Row >= grid.length
            || person1Column >= grid.length
            || person2Row >= grid.length
            || person2Column >= grid.length;
        if (outOfBounds) {
            return Integer.MIN_VALUE + 1;
        }
        
        boolean stepIsOnThorn = grid[person1Row][person1Column] == -1
            || grid[person2Row][person2Column] == -1;
        if (stepIsOnThorn) {
            return Integer.MIN_VALUE + 1;
        }
        
        if (person1Row == grid.length - 1 && person1Column == grid.length - 1) {
            return grid[grid.length - 1][grid.length - 1];
        }
        
        if (memo[person1Row][person1Column][person2Column] > Integer.MIN_VALUE) {
            return memo[person1Row][person1Column][person2Column];
        }
        
        int cherriesFromCurrentStep = grid[person1Row][person1Column];
        if (person1Column != person2Column) {
            cherriesFromCurrentStep += grid[person2Row][person2Column];
        }
        
        cherriesFromCurrentStep += Math.max(
            Math.max(
                dp(grid, memo, person1Row + 1, person1Column, person2Column),
                dp(grid, memo, person1Row + 1, person1Column, person2Column + 1)
            ),
            Math.max(
                dp(grid, memo, person1Row, person1Column + 1, person2Column),
                dp(grid, memo, person1Row, person1Column + 1, person2Column + 1)
            )
        );
        
        memo[person1Row][person1Column][person2Column] = cherriesFromCurrentStep;
        
        return cherriesFromCurrentStep;
    }
}
