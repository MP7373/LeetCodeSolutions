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
    
    int max = 0;

    public int maxPathSum(TreeNode root) {
        if (root != null) {
            max = root.val;
        }

        maxPath(root);
        
        return max;
    }
    
    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        var left = maxPath(root.left);
        var right = maxPath(root.right);
        
        var possibleMax = Math.max(
            root.val,
            Math.max(
                root.val + left,
                Math.max(
                    root.val + right,
                    root.val + left + right
                )
            )
        );
        
        if (possibleMax > max) {
            max = possibleMax;
        }
        
        return Math.max(root.val, Math.max(root.val + left, root.val + right));
    }
}
