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
  public TreeNode buildTree(int[] inorder, int[] postorder) {
      Map<Integer, Integer> inorderValToIndexMap = new HashMap<>();
      for (int i = 0; i < inorder.length; i++) {
          inorderValToIndexMap.put(inorder[i], i);
      }

      return constructTree(inorderValToIndexMap, inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
  }

  private TreeNode constructTree(
      Map<Integer, Integer> inorderValToIndexMap,
      int[] inorder,
      int[] postorder,
      int inorderLeft,
      int inorderRight,
      int postorderRight
  ) {
      if (inorderLeft > inorderRight || postorderRight < 0) {
          return null;
      }

      int inorderRootIndex = inorderValToIndexMap.get(postorder[postorderRight]);

      TreeNode right = constructTree(
          inorderValToIndexMap,
          inorder,
          postorder,
          inorderRootIndex + 1,
          inorderRight,
          postorderRight - 1
      );

      int numberOfRightNodes = inorderRight - inorderRootIndex;
      TreeNode left = constructTree(
          inorderValToIndexMap,
          inorder,
          postorder,
          inorderLeft,
          inorderRootIndex - 1,
          postorderRight - numberOfRightNodes - 1
      );

      return new TreeNode(postorder[postorderRight], left, right);
  }
}
