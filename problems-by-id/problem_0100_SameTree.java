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
  public boolean isSameTree(TreeNode p, TreeNode q) {
      return isSameTree(new TwoTrees(p, q));
  }

  private boolean isSameTree(TwoTrees t) {
      return t != null &&
          (t.a == null && t.b == null) ||
          (
              (t.a != null && t.b != null) &&
              (t.a.val == t.b.val)) &&
              isSameTree(new TwoTrees(t.a != null ? t.a.left : null, t.b != null ? t.b.left : null)) &&
              isSameTree(new TwoTrees(t.a != null ? t.a.right : null, t.b != null ? t.b.right : null)
          );
  }
}

class TwoTrees {
  TreeNode a;
  TreeNode b;

  TwoTrees(TreeNode A, TreeNode B) {
      a = A;
      b = B;
  }
}
