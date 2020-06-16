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
    private int max = 0;

    public int DiameterOfBinaryTree(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        GetLongestPathFromNode(root);

        return max;
    }

    private int GetLongestPathFromNode(TreeNode node)
    {
        var left = 0;
        if (node.left != null)
        {
            left = GetLongestPathFromNode(node.left) + 1;
        }

        var right = 0;
        if (node.right != null)
        {
            right = GetLongestPathFromNode(node.right) + 1;
        }

        if (left + right > max)
        {
            max = left + right;
        }

        return Math.Max(left, right);
    }
}
