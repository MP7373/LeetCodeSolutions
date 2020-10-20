/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Integer, Node> usedNodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        var newNode = new Node(node.val);
        usedNodes.put(node.val, newNode);

        for (var neighbor : node.neighbors) {
            Node newNeighbor;
            if (usedNodes.containsKey(neighbor.val)) {
                newNeighbor = usedNodes.get(neighbor.val);
            } else {
                newNeighbor = cloneGraph(neighbor);
            }

            newNode.neighbors.add(newNeighbor);
        }

        return newNode;
    }
}
