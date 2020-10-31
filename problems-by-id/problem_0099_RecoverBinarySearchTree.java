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
    private List<TreeNode> sortedNodes;

    public void recoverTree(TreeNode root) {
        sortedNodes = new ArrayList<>();

        sortNodes(root);

        var wrong1 = -1;
        var wrong2 = -1;

        for (var i = 0; i < sortedNodes.size() - 1; i++) {
            if (sortedNodes.get(i).val > sortedNodes.get(i + 1).val) {
                if (wrong1 == -1) {
                    wrong1 = i;
                }

                wrong2 = i + 1;
            }
        }

        var temp = sortedNodes.get(wrong1).val;
        sortedNodes.get(wrong1).val = sortedNodes.get(wrong2).val;
        sortedNodes.get(wrong2).val = temp;
    }

    private void sortNodes(TreeNode node) {
        if (node == null) {
            return;
        }

        sortNodes(node.left);
        sortedNodes.add(node);
        sortNodes(node.right);
    }
}
