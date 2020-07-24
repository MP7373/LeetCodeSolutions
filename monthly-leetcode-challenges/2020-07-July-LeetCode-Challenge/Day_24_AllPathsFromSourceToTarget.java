class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();

        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        visit(allPaths, currentPath, 0, graph);

        return allPaths;
    }

    private void visit(List<List<Integer>> allPaths, List<Integer> currentPath, int node, int[][] graph) {
        if (node == graph.length - 1) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }

        for (int neighbor : graph[node]) {
            currentPath.add(neighbor);
            visit(allPaths, currentPath, neighbor, graph);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
