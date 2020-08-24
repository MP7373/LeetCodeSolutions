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
      int sum = 0;

      TreeNode cur = root;
      while (cur != null) {
          TreeNode last = cur.left;

          if (last == null) {
              cur = cur.right;
          } else {
              if (last.left == null && last.right == null) {
                  sum += last.val;
              }

              while (last.right != null && last.right != cur) {
                  last = last.right;
              }

              if (last.right == cur) {
                  last.right = null;
                  cur = cur.right;
              } else {
                  last.right = cur;
                  cur = cur.left;
              }
          }
      }

      return sum;
  }
}
