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
  public int sumOfLeftLeaves(TreeNode root) {
      return sumOfLeftLeaves(root, false);
  }

  private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
      if (root == null) {
          return 0;
      }

      if (root.left == null && root.right == null) {
          if (isLeft) {
              return root.val;
          }

          return 0;
      }

      int sum = 0;
      if (root.left != null) {
          sum += sumOfLeftLeaves(root.left, true);
      }

      if (root.right != null) {
          sum += sumOfLeftLeaves(root.right, false);
      }

      return sum;
  }
}
