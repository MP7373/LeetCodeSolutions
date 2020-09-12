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
  public boolean isCousins(TreeNode root, int x, int y) {
      var xResult = findDepthAndParent(new ParentDepthChild(null, 0, root), x);
      var yResult = findDepthAndParent(new ParentDepthChild(null, 0, root), y);

      return xResult.depth == yResult.depth && xResult.parent != yResult.parent;
  }

  private ParentDepthChild findDepthAndParent(ParentDepthChild parentDepthChild, int value) {
      var node = parentDepthChild.child;

      if (node == null) {
          return null;
      }

      if (node.val == value) {
          return parentDepthChild;
      }

      var left = findDepthAndParent(new ParentDepthChild(node, parentDepthChild.depth + 1, node.left), value);

      return left != null ?
          left :
          findDepthAndParent(new ParentDepthChild(node, parentDepthChild.depth + 1, node.right), value);
  }
}

class ParentDepthChild {
  TreeNode parent;
  int depth;
  TreeNode child;

  ParentDepthChild(TreeNode p, int d, TreeNode c) {
      parent = p;
      depth = d;
      child = c;
  }
}
