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
  public List<List<Integer>> verticalTraversal(TreeNode root) {
      if (root == null) {
          return new ArrayList<>();
      }

      Map<Integer, Map<Integer, Set<Integer>>> valuesForXCoordMap = new HashMap<>();
      int minX = 0;
      int maxX = 0;
      ArrayDeque<WorkItem> q = new ArrayDeque<>();
      q.add(new WorkItem(root, 0, 0));

      while (!q.isEmpty()) {
          WorkItem work = q.pollFirst();

          minX = Math.min(minX, work.x);
          maxX = Math.max(maxX, work.x);

          if (!valuesForXCoordMap.containsKey(work.x)) {
              valuesForXCoordMap.put(work.x, new TreeMap<>((a, b) -> b - a));
          }
          Map<Integer, Set<Integer>> xMap = valuesForXCoordMap.get(work.x);
          if (!xMap.containsKey(work.y)) {
              xMap.put(work.y, new TreeSet<>());
          }
          xMap.get(work.y).add(work.node.val);

          if (work.node.left != null) {
              q.addLast(new WorkItem(work.node.left, work.y - 1, work.x - 1));
          }

          if (work.node.right != null) {
              q.addLast(new WorkItem(work.node.right, work.y - 1, work.x + 1));
          }
      }

      List<List<Integer>> results = new ArrayList<>();
      for (int x = minX; x <= maxX; x++) {
          List<Integer> layer = new ArrayList<>();
          for (int key : valuesForXCoordMap.get(x).keySet()) {
              for (int num : valuesForXCoordMap.get(x).get(key)) {
                  layer.add(num);
              }
          }
          results.add(layer);
      }

      return results;
  }
}

class WorkItem {
  TreeNode node;
  int y;
  int x;

  WorkItem(TreeNode node, int y, int x) {
      this.node = node;
      this.y = y;
      this.x = x;
  }
}
