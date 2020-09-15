/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
  public Node inorderSuccessor(Node node) {
      if (node == null) {
          return null;
      }

      Node smallestFromRight = getSmallestNodeFromRoot(node.right);

      return smallestFromRight != null ?
          smallestFromRight :
          getFirstParentLargerThanValue(node.parent, node.val);
  }

  private Node getSmallestNodeFromRoot(Node n) {
      while (n != null && n.left != null) {
          n = n.left;
      }

      return n;
  }

  private Node getFirstParentLargerThanValue(Node n, int value) {
      while (n != null && n.val < value) {
          n = n.parent;
      }

      return n;
  }
}
