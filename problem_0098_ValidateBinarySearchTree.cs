/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public bool IsValidBST(TreeNode root) => IsValid(root, Int64.MinValue, Int64.MaxValue);
    
    public bool IsValid(TreeNode root, long min, long max) =>
        root == null ||
        ((long) root.val > min &&
        (long) root.val < max &&
        IsValid(root.left, min, root.val) &&
        IsValid(root.right, root.val, max));
}
