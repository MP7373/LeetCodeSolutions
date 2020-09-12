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
  private int sum = 0;

  public int sumNumbers(TreeNode root) {
      sumNumbers(root, 0);

      return sum;
  }

  private void sumNumbers(TreeNode root, int localSum) {
      if (root == null) {
          return;
      }

      localSum = localSum == 0 ? root.val : localSum * 10 + root.val;
      if (root.left == null && root.right == null) {
          sum += localSum;
      }

      if (root.left != null) {
          sumNumbers(root.left, localSum);
      }

      if (root.right != null) {
          sumNumbers(root.right, localSum);
      }
  }
}
