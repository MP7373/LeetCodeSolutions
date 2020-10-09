/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        var sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append("," + root.val);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        var stack = new ArrayDeque<ArrayDeque<TreeNode>>();
        TreeNode root = null;

        var nums = new ArrayList<Integer>();
        for (var num : data.split(",")) {
            if (num.equals("")) {
                continue;
            }

            var number = Integer.parseInt(num);

            nums.add(number);
        }

        index = 0;


        return deserialize(nums, Integer.MAX_VALUE);
    }

    int index = 0;

    public TreeNode deserialize(List<Integer> nums, int parentVal) {
        if (index >= nums.size()) {
            return null;
        }

        int val = nums.get(index);
        TreeNode node = new TreeNode(val);

        index++;
        if (index >= nums.size()) {
            return node;
        }

        int nextVal = nums.get(index);
        if (nextVal < val) {
            node.left = deserialize(nums, val);
        }

        if (index >= nums.size()) {
            return node;
        }

        nextVal = nums.get(index);
        if (nextVal < parentVal) {
            node.right = deserialize(nums, parentVal);
        }

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
