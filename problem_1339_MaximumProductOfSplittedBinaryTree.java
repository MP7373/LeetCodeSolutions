
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
public class problem_1339_MaximumProductOfSplittedBinaryTree {
    
    private long sum = 0L;
    private long maxProduct = Long.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        sum = 0L;
        maxProduct = Long.MIN_VALUE;
        
        this.sumTree(root);
        
        this.findMaxProduct(root);
        
        return (int) (maxProduct % 1000000007);
    }
    
    private void sumTree(TreeNode root) {
        if (root != null) {
            sum += root.val;
        }
        
        if (root.left != null) {
            sumTree(root.left);
        }
        
        if (root.right != null) {
            sumTree(root.right);
        }
    }
    
    private long findMaxProduct(TreeNode root) {
        if (root == null) {
            return 0L;
        }
        
        long localSum = (long) root.val;
        
        if (root.left != null) {
            localSum += findMaxProduct(root.left);
        }
        
        if (root.right != null) {
            localSum += findMaxProduct(root.right);
        }
        
        long productFromHere = localSum * (sum - localSum);
        if (productFromHere > maxProduct) {
            maxProduct = productFromHere;
        }
        
        return localSum;
    }
}
