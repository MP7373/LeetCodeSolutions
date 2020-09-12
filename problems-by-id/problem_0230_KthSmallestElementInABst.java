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
  Map<TreeNode, Integer> nodesFromRootMap = new HashMap<>();

  public int kthSmallest(TreeNode root, int k) {
      if (root == null) {
          return 0;
      }

      var smaller = 0;

      while (true) {
          var currentLeft = countNodesFromRoot(root.left);
          smaller += currentLeft;

          if (smaller == k - 1) {
              return root.val;
          } else if (smaller > k - 1) {
              root = root.left;
              smaller -= currentLeft;
          } else {
              root = root.right;
              smaller += 1;
          }
      }
  }

  public int countNodesFromRoot(TreeNode root) {
      if (root == null) {
          return 0;
      }

      if (nodesFromRootMap.containsKey(root)) {
          return nodesFromRootMap.get(root);
      }

      var nodesFromRoot = 1 + countNodesFromRoot(root.left) + countNodesFromRoot(root.right);

      nodesFromRootMap.put(root, nodesFromRoot);

      return nodesFromRoot;
  }
}
