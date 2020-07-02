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
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
      var map = new HashMap<Integer, List<Integer>>();
      
      fillMapWithNodes(root, 0, map);
      
      var listOfLevels = new ArrayList<List<Integer>>();
      for (var i = 0; map.containsKey(i); i++) {
          var level = new ArrayList<Integer>();
          
          for (var nodeVal : map.get(i)) {
              level.add(nodeVal);
          }
          
          listOfLevels.add(level);
      }
      
      Collections.reverse(listOfLevels);
      
      return listOfLevels;
  }
  
  private void fillMapWithNodes(TreeNode root, int level, HashMap<Integer, List<Integer>> map) {
      if (root == null) {
          return;
      }

      if (!map.containsKey(level)) {
          map.put(level, new ArrayList<Integer>());
      }
      
      map.get(level).add(root.val);
      
      fillMapWithNodes(root.left, level + 1, map);
      fillMapWithNodes(root.right, level + 1, map);
  }
}
