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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      Map<Integer, List<Integer>> levelMap = new HashMap<>();
      fillMap(root, 0, levelMap);

      List<List<Integer>> result = new ArrayList<>();
      for (int i = 0; i < levelMap.keySet().size(); i++) {
          if (i % 2 == 1) {
              Collections.reverse(levelMap.get(i));
          }
          result.add(levelMap.get(i));
      }

      return result;
  }

  private void fillMap(TreeNode root, int level, Map<Integer, List<Integer>> levelMap) {
      if (root == null) {
          return;
      }

      if (!levelMap.containsKey(level)) {
          levelMap.put(level, new ArrayList<>());
      }

      levelMap.get(level).add(root.val);

      fillMap(root.left, level + 1, levelMap);
      fillMap(root.right, level + 1, levelMap);
  }
}
