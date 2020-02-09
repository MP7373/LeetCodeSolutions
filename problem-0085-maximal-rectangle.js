/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
  let min = 0;
  
  function checkRecDown(matrix, startRow, startCol) {
      
      let row = startRow;
      let maxCol = matrix[0].length - 1;
      
      
      while (row < matrix.length && matrix[row][startCol] == 1) {
          const height = row - startRow + 1;
          const maxArea = height * (maxCol - startCol + 1);

          maxCol = Math.min(maxCol, checkRecRight(matrix, startRow, row, startCol, maxCol));

          
          row++;
      }
  }
  
  function checkRecRight(matrix, startRow, row, startCol, maxCol) {
      const height = row - startRow + 1;

      let col = startCol;

      while (col <= maxCol && matrix[row][col] == 1) {
          const width = col - startCol + 1;
          const area = height * width;
          
          if (area > min) {
              min = area;
          }
          
          col++;
      }
      
      
      
      return col - 1;
  }
  
  for (let i = 0; i < matrix.length; i++) {
      for (let j = 0; j < matrix[0].length; j++) {
          checkRecDown(matrix, i, j);
      }
  }
  
  return min;
};
