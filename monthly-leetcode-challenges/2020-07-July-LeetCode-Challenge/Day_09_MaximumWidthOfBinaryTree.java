/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  private int maxWidth = 0;

  public synchronized int widthOfBinaryTree(TreeNode root) {
      maxWidth = 0;
      traverse(root, 0, 0, new HashMap<Integer, MinMax>());
      return maxWidth;
  }

  private synchronized void traverse(TreeNode root, int level, int leftRight, Map<Integer, MinMax> levelWidthMap) {
      if (root == null) {
          return;
      }

      var minMax = levelWidthMap.getOrDefault(level, new MinMax(leftRight, leftRight));
      minMax.min = Math.min(minMax.min, leftRight);
      minMax.max = Math.max(minMax.max, leftRight);
      levelWidthMap.put(level, minMax);

      if (minMax.max - minMax.min + 1 >= maxWidth) {
          maxWidth = minMax.max - minMax.min + 1;
      }

      traverse(root.left, level + 1, leftRight * 2, levelWidthMap);
      traverse(root.right, level + 1, leftRight * 2 + 1, levelWidthMap);
  }
}

class MinMax {
  int min;
  int max;

  MinMax(int min, int max) {
      this.min = min;
      this.max = max;
  }
}
