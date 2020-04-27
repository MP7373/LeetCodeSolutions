class Solution {
    
    public int maximalSquare(char[][] matrix) {
        int maxSquare = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                maxSquare = Math.max(maxSquare, maxSquareFromCorner(row, column, matrix));
            }
        }

        return maxSquare;
    }
    
    private static int maxSquareFromCorner(int y, int x, char[][] matrix) {
        int size = 0;
        
        while (y + size < matrix.length && x + size < matrix[0].length) {       
            for (int row = y; row < matrix.length && row <= y + size; row++) {
                if (matrix[row][x + size] != '1') {
                    return size * size;
                }
            }
            
            for (int column = x; column < matrix[0].length && column <= x + size; column++) {
                if (matrix[y + size][column] != '1') {
                    return size * size;
                }
            }
            
            size++;
        }
        
        return size * size;
    }
}
