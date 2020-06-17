class Solution {
    public void solve(char[][] board) {
        var visited = new HashSet<Node>();

        for (var y = 0; y < board.length; y++) {
            for (var x = 0; x < board[0].length; x++) {
                var node = new Node(x, y);
                
                if (board[y][x] == 'O' && !visited.contains(node)) {
                    var region = new Region();
                    
                    createRegionOfConnectedOs(region, node, board, visited);
                    
                    if (
                        region.minX > 0 &&
                        region.maxX < board[0].length - 1 &&
                        region.minY > 0 &&
                        region.maxY < board.length - 1
                    ) {
                        for (var xy : region.nodes) {
                            board[xy.y][xy.x] = 'X';
                        }
                    }
                }
            }
        }
    }
    
    private void createRegionOfConnectedOs(Region region, Node node, char[][] board, Set<Node> visited) {
        region.add(node);
        visited.add(node);
        
        if (node.x + 1 < board[0].length && board[node.y][node.x + 1] == 'O') {
            var goLeftNode = new Node(node.x + 1, node.y);
            
            if (!visited.contains(goLeftNode)) {
                createRegionOfConnectedOs(region, goLeftNode, board, visited);
            }
        }
        
        if (node.y + 1 < board.length && board[node.y + 1][node.x] == 'O') {
            var goDownNode = new Node(node.x, node.y + 1);
            
            if (!visited.contains(goDownNode)) {
                createRegionOfConnectedOs(region, goDownNode, board, visited);
            }
        }
        
        if (node.x - 1 >= 0 && board[node.y][node.x - 1] == 'O') {
            var goRightNode = new Node(node.x - 1, node.y);
            
            if (!visited.contains(goRightNode)) {
                createRegionOfConnectedOs(region, goRightNode, board, visited);
            }
        }
        
        if (node.y - 1 >= 0 && board[node.y - 1][node.x] == 'O') {
            var goUpNode = new Node(node.x, node.y - 1);
            
            if (!visited.contains(goUpNode)) {
                createRegionOfConnectedOs(region, goUpNode, board, visited);
            }
        }
    }
}

class Region {
    Set<Node> nodes = new HashSet<>();
    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxY = Integer.MIN_VALUE;
    
    void add(Node node) {
        if (!nodes.contains(node)) {
            nodes.add(node);
            minX = Math.min(node.x, minX);
            maxX = Math.max(node.x, maxX);
            minY = Math.min(node.y, minY);
            maxY = Math.max(node.y, maxY);
        }
    }
}

class Node {
    int x;
    int y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        var oNode = (Node) o;
        return x == oNode.x && y == oNode.y;
    }
    
    public int hashCode() {
        return x + y * 100000;
    }
}
