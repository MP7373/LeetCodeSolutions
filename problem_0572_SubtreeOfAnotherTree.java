import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
  public boolean isSubtree(TreeNode s, TreeNode t) {
      Queue<TreeNode> q = new ArrayDeque<>();
      q.add(s);
      
      while (q.size() > 0) {
          TreeNode root = q.poll();
          
          if (treesAreEqual(root, t)) {
              return true;
          }
          
          if (root.left != null) {
              q.add(root.left);
          }
          
          if (root.right != null) {
              q.add(root.right);
          }
      }
      
      return false;
  }
  
  private static boolean treesAreEqual(TreeNode s, TreeNode t) {
      return (s == null && t == null) || ((s != null && t != null && s.val == t.val)
          && treesAreEqual(s.left, t.left)
          && treesAreEqual(s.right, t.right));
  }
}
