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
  private int bottomRowMaxIndex = -1;

  public int countNodes(TreeNode root) {
      var depth = getTreeDepth(root);
      var bottomRowSize = (int) Math.pow(2, depth - 1);

      var highestBottomIndex = binarySearchForBottomRowMaxIndex(
          root,
          depth,
          bottomRowSize,
          0,
          bottomRowSize - 1
      );
      return (int) Math.pow(2, depth) - bottomRowSize + highestBottomIndex;
  }

  private int getTreeDepth(TreeNode root) {
      return root == null ? 0 : 1 + getTreeDepth(root.left);
  }

  private int binarySearchForBottomRowMaxIndex(
      TreeNode root,
      int depth,
      int bottomRowSize,
      int left,
      int right
  ) {
      var mid = left + (right - left) / 2;

      var midNodeExists = bottomRowNodeExistsAtIndex(root, depth, mid);

      if (midNodeExists) {
          if (mid == bottomRowSize - 1 || !bottomRowNodeExistsAtIndex(root, depth, mid + 1)) {
              return mid;
          }

          return binarySearchForBottomRowMaxIndex(root, depth, bottomRowSize, mid + 1, right);
      }

      if (mid <= 0) {
          return -1;
      }

      return binarySearchForBottomRowMaxIndex(root, depth, bottomRowSize, left, mid - 1);
  }

  private boolean bottomRowNodeExistsAtIndex(TreeNode root, int depth, int nodeIndex) {
      if (nodeIndex <= bottomRowMaxIndex) {
          return true;
      }

      var bottomRowSize = Math.pow(2, depth - 1);
      var index = 0;
      var currentDepth = 1;
      var goRightSize = bottomRowSize / 2;

      while (currentDepth < depth) {
          if (index + goRightSize > nodeIndex) {
              root = root.left;
          } else {
              root = root.right;
              index += goRightSize;
          }

          goRightSize /= 2;
          currentDepth++;
      }

      if (root != null) {
          bottomRowMaxIndex = nodeIndex;
          return true;
      }

      return false;
  }
}
