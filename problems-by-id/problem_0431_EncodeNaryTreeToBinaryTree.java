/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node node) {
        if (node == null) {
            return null;
        }

        var binaryNode = new TreeNode(node.val);
        TreeNode childrenGoRightStackHead = null;

        if (node.children != null) {
            TreeNode lastChildGoingRight = null;

            for (var child : node.children) {
                if (child != null) {
                    var childTree = encode(child);
                    if (childrenGoRightStackHead == null) {
                        childrenGoRightStackHead = childTree;
                        lastChildGoingRight = childTree;
                    } else {
                        lastChildGoingRight.right = childTree;
                        lastChildGoingRight = lastChildGoingRight.right;
                    }
                }
            }
        }

        binaryNode.left = childrenGoRightStackHead;

        return binaryNode;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode binaryNode) {
        if (binaryNode == null) {
            return null;
        }

        var node = new Node(binaryNode.val, new ArrayList<Node>());

        if (binaryNode.left == null) {
            return node;
        }

        var child = binaryNode.left;
        while (child != null) {
            var childTree = decode(child);
            if (childTree != null) {
                node.children.add(childTree);
            }

            child = child.right;
        }

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
