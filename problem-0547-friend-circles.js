/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function(M) {
  const visited = new Set()
  let circles = 0

  for (let i = 0; i < M.length; i++) {
      if (!visited.has(i)) {
          visited.add(i)
          search(M, i, visited)
          circles++
      }
  }
  
  return circles
}

function search(M, friend, visited) {
  const friends = M[friend]
  
  for (let i = 0; i < friends.length; i++) {
      if (!visited.has(i) && friends[i] === 1) {
          visited.add(i)
          search(M, i, visited)
      }
  }
}
