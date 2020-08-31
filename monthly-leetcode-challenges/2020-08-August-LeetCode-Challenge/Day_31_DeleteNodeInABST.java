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
  public TreeNode deleteNode(TreeNode root, int key) {
      TreeNode parent = new TreeNode(-1);
      parent.right = root;
      boolean leftChild = false;

      TreeNode node = root;
      root = parent;

      while (node != null && key != node.val) {
          parent = node;
          if (key < node.val) {
              node = node.left;
              leftChild = true;
          } else {
              node = node.right;
              leftChild = false;
          }
      }

      if (node != null) {
          if (leftChild) {
              if (node.right != null) {
                  parent.left = node.right;

                  TreeNode right = node.right;

                  while (right.left != null) {
                      right = right.left;
                  }

                  right.left = node.left;
              } else {
                  parent.left = node.left;
              }
          } else {
              if (node.right != null) {
                  parent.right = node.right;

                  TreeNode right = node.right;

                  while (right.left != null) {
                      right = right.left;
                  }

                  right.left = node.left;
              } else {
                  parent.right = node.left;
              }
          }
      }

      return root.right;
  }
}
