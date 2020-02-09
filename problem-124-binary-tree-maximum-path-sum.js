/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxPathSum = function(root) {
  let max = root.val
  
  function findMax(node) {
      if (node == null) {
          return 0
      }

      if (node.left == null && node.right == null) {
          if (node.val > max) {
              max = node.val
          }

          return node.val
      }
      
      if (node.right == null) {
          const localMax = Math.max(node.val, node.val + findMax(node.left))
          
          if (localMax > max) {
              max = localMax
          }
          
          return localMax
      }
      
      const leftMax = findMax(node.left)
      const rightMax = findMax(node.right)
      const localMax = Math.max(node.val,
                                node.val + leftMax,
                                node.val + rightMax)

      if (localMax > max) {
          max = localMax
      }
      
      const bothSidesSum = node.val + leftMax + rightMax
      if (bothSidesSum > max) {
          max = bothSidesSum
      }

      return localMax
  }
  
  const possibleMax = findMax(root)
  
  return Math.max(max, possibleMax)
};
