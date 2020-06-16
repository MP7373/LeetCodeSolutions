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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode head = null;
        var stack = new Stack<NodeWithParent>();
        
        for (var n : preorder) {
            var node = new TreeNode(n);
            
            while (!stack.empty() && n > stack.peek().max) {
                stack.pop(); 
            }
            
            int max = Integer.MAX_VALUE;

            if (!stack.empty()) {
                if (n < stack.peek().node.val) {
                    max = stack.peek().node.val;
                    stack.peek().node.left = node;
                } else {
                    stack.peek().node.right = node;
                    max = stack.peek().max;
                }
            }

            stack.push(new NodeWithParent(node, max));
            
            if (head == null) {
                head = node;
            }
        }
        
        return head;
    }
    
    class NodeWithParent {
        TreeNode node;
        int max;
        NodeWithParent(TreeNode n, int m) {
            node = n;
            max = Math.max(node.val, m);
        }
    }
}
