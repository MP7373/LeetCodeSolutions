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

  public int sumRootToLeaf(TreeNode root) {
      sum = 0;
      sumRootToLeaf(root, 0);
      return sum;
  }

  public void sumRootToLeaf(TreeNode node, int binaryValue) {
      if (node == null) {
          return;
      }

      int newBinaryValue = (binaryValue << 1) + node.val;

      if (node.left == null && node.right == null) {
          sum += newBinaryValue;
          return;
      }

      if (node.left != null) {
          sumRootToLeaf(node.left, newBinaryValue);
      }

      if (node.right != null) {
          sumRootToLeaf(node.right, newBinaryValue);
      }
  }
}
