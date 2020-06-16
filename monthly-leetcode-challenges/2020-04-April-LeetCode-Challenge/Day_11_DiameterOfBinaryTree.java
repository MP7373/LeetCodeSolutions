/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private int longestDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return longestDiameter;
    }
    
    private int longestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        var left = node.left == null ? 0 : longestPath(node.left);
        var right = node.right == null ? 0 : longestPath(node.right);
        
        longestDiameter = Math.max(longestDiameter, left + right);
        
        return Math.max(left, right) + 1;
    }
}
