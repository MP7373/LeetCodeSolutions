using System;

public class Solution
{
    public void Rotate(int[][] matrix)
    {
        var n = matrix.Length;

        for (var outer = 0; outer < n / 2; outer++)
        {
            for (var x = outer; x < n - 1 - outer; x++)
            {
                var y = outer;

                var temp = matrix[y][x];
                matrix[y][x] = matrix[n - 1 - x][y];
                matrix[n - 1 - x][y] = matrix[n - 1 - y][n - 1 - x];
                matrix[n - 1 - y][n - 1 - x] = matrix[x][n - 1 - y];
                matrix[x][n - 1 - y] = temp;
            }
        }
    }
}
