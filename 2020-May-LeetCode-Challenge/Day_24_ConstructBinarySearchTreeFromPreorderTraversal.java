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
        var stack = new Stack<TreeNode>();

        for (var num : preorder) {
            var node = new TreeNode(num);

            if (head == null) {
                head = node;
            }

            if (stack.size() == 0) {
                stack.push(node);
            } else {
                var numAdded = false;
                
                while (!numAdded) {
                    
                    var top = stack.pop();

                    if (num < top.val) {
                        top.left = node;

                        stack.push(top);
                        stack.push(node);
                        numAdded = true;
                    } else {
                        var twoUp = stack.size() > 0 ? stack.pop() : null;
                        
                        if (twoUp == null || (num > top.val && num < twoUp.val)) {
                            top.right = node;

                            if (twoUp != null)
                                stack.push(twoUp);
                            stack.push(node);
                            numAdded = true;
                        } else {
                            if (twoUp != null)
                                stack.push(twoUp);
                        }
                    }
                }
            }
        }
        
        return head;
    }
}