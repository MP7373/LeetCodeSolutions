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
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      InOrderBinaryTreeIterator tree1Iterator = new InOrderBinaryTreeIterator(root1);
      InOrderBinaryTreeIterator tree2Iterator = new InOrderBinaryTreeIterator(root2);

      List<Integer> allElementsInOrder = new ArrayList<>();

      while (tree1Iterator.get() != null && tree2Iterator.get() != null) {
          if (tree1Iterator.get().val <= tree2Iterator.get().val) {
              allElementsInOrder.add(tree1Iterator.get().val);
              tree1Iterator.getNext();
          } else {
              allElementsInOrder.add(tree2Iterator.get().val);
              tree2Iterator.getNext();
          }
      }

      while (tree1Iterator.get() != null) {
          allElementsInOrder.add(tree1Iterator.get().val);
          tree1Iterator.getNext();
      }

      while (tree2Iterator.get() != null) {
          allElementsInOrder.add(tree2Iterator.get().val);
          tree2Iterator.getNext();
      }

      return allElementsInOrder;
  }
}

class InOrderBinaryTreeIterator {
  private TreeNode node;
  private boolean isInitialized = false;

  InOrderBinaryTreeIterator(TreeNode root) {
      node = root;
  }

  TreeNode get() {
      if (!isInitialized) {
          getNext();
      }

      return node;
  }

  // morris tree traversal, return before going right to get in order
  TreeNode getNext() {
      if (isInitialized) {
          node = node.right;
      }
      isInitialized = true;

      while (node != null) {
          if (node.left != null) {
              TreeNode next = node.left;

              while (next.right != null && next.right != node) {
                  next = next.right;
              }

              if (next.right == null) {
                  next.right = node;
                  node = node.left;
              } else {
                  next.right = null;
                  return node;
              }
          } else {
              return node;
          }
      }

      return node;
  };
}
