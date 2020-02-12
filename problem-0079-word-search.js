/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
  for (let row = 0; row < board.length; row++) {
      for (let column = 0; column < board[0].length; column++) {
          if (board[row][column] === word[0]) {
              const canMakeWordFromHere = canMakeWordDepthFirstSearch(board, word, row, column)

              if (canMakeWordFromHere) {
                  return true
              }
          }
      }
  }
  
  return false
};

function canMakeWordDepthFirstSearch(board, word, row, column) {    
  const queue = [[row, column, 0, new Set()]]

  do {
      const [row, column, wordIndex, visited] = queue.pop()

      if (visited.has(`${row},${column}`)) {
          continue
      }
      const nextVisited = new Set([...visited, `${row},${column}`])

      const char = board[row][column]
      
      if (wordIndex >= word.length - 1 && word[wordIndex] === char) {
          return true
      }
      
      const nextWordIndex = wordIndex + 1
      if (nextWordIndex >= word.length) {
          continue
      }
      
      const oneDown = row + 1
      if (oneDown < board.length && board[oneDown][column] === word[nextWordIndex]) {
          queue.push([oneDown, column, nextWordIndex, nextVisited])
      }
      
      const oneUp = row - 1
      if (oneUp >= 0 && board[oneUp][column] === word[nextWordIndex]) {
          queue.push([oneUp, column, nextWordIndex, nextVisited])
      }
      
      const oneRight = column + 1
      if (oneRight < board[0].length && board[row][oneRight] === word[nextWordIndex]) {
          queue.push([row, oneRight, nextWordIndex, nextVisited])
      }
      
      const oneLeft = column - 1
      if (oneLeft >= 0 && board[row][oneLeft] === word[nextWordIndex]) {
          queue.push([row, oneLeft, nextWordIndex, nextVisited])
      }
  } while(queue.length > 0)
  
  return false
}
