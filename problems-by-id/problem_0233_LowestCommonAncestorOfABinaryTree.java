import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
class Solution {
  Map<TreeNode, TreeNode> parents = new HashMap<>();

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      fillParents(root, null);
      
      TreeNode lca = p;
      boolean found = hasChild(lca, q);
      while (lca != null && !found) {
          lca = parents.get(lca);
          found = hasChild(lca, q);
      }
      
      return lca;
  }
  
  private void fillParents(TreeNode root, TreeNode parent) {
      if (root == null) {
          return;
      }

      parents.put(root, parent);
      
      fillParents(root.left, root);
      fillParents(root.right, root);
  }
  
  private boolean hasChild(TreeNode root, TreeNode child) {
      if (root == null) {
          return false;
      }
      
      if (root == child) {
          return true;
      }
      
      if (hasChild(root.left, child)) {
          return true;
      }
      
      return hasChild(root.right, child);
  }
}
