/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<int> RightSideView(TreeNode root) {
        var heights = new List<int>();

        traverse(root, 1, heights);

        return heights;
    }

    private void traverse(TreeNode root, int height, List<int> heights) {
        if (root == null) {
            return;
        }

        if (heights.Count() < height) {
            heights.Add(root.val);
        }

        traverse(root.right, height + 1, heights);
        traverse(root.left, height + 1, heights);
    }
}
