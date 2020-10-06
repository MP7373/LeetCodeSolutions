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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode cur = root;
        TreeNode next = root;
        while (cur != null) {
            if (val < cur.val) {
                next = cur.left;

                if (next == null) {
                    cur.left = new TreeNode(val);
                }
            } else {
                next = cur.right;

                if (next == null) {
                    cur.right = new TreeNode(val);
                }
            }

            cur = next;
        }

        return root;
    }
}
