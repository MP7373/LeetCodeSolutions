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
    private Integer closestValue = null;
    private Double closestDistance = null;

    public int closestValue(TreeNode root, double target) {
        closestValue = null;
        closestDistance = null;
        findClosest(root, target);

        return closestValue;
    }

    private void findClosest(TreeNode node, double target) {
        if (node == null) {
            return;
        }

        double distance = Math.abs(node.val - target);
        if (closestDistance == null || distance < closestDistance) {
            closestValue = node.val;
            closestDistance = distance;
        }

        findClosest(node.left, target);
        findClosest(node.right, target);
    }
}
