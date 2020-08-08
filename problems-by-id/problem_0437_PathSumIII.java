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
  private int totalPaths = 0;

  public int pathSum(TreeNode root, int sum) {
      totalPaths = 0;
      possibleSums(root, sum);

      return totalPaths;
  }

  private List<Integer> possibleSums(TreeNode node, int desiredSum) {
      if (node == null) {
          return new ArrayList<>();
      }

      List<Integer> next = new ArrayList<>();

      if (node.val == desiredSum) {
          totalPaths++;
      }
      next.add(node.val);

      for (int n : possibleSums(node.left, desiredSum)) {
          if (n + node.val == desiredSum) {
              totalPaths++;
          }
          next.add(n + node.val);
      }

      for (int n : possibleSums(node.right, desiredSum)) {
          if (n + node.val == desiredSum) {
              totalPaths++;
          }
          next.add(n + node.val);
      }

      return next;
  }
}
