class Solution {
    private int finalCost;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        var nodes = new HashMap<Integer, Map<Integer, Integer>>();
        
        for (var flight : flights) {
            if (nodes.containsKey(flight[0])) {
                var neighborCostMap = nodes.get(flight[0]);
                
                if (neighborCostMap.containsKey(flight[1])) {
                    var currentCheapest = neighborCostMap.get(flight[1]);
                    
                    if (flight[2] < currentCheapest) {
                        neighborCostMap.put(flight[1], flight[2]);
                    }
                } else {
                    neighborCostMap.put(flight[1], flight[2]);
                }
            } else {
                var neighborCostMap = new HashMap<Integer, Integer>();
                neighborCostMap.put(flight[1], flight[2]);
                nodes.put(flight[0], neighborCostMap);
            }
        }
        
        var costs = new HashMap<Integer, Integer>();
        var steps = new HashMap<Integer, Integer>();
        
        var work = new PriorityQueue<WorkItem>((a, b) -> a.totalCost - b.totalCost);
        work.add(new WorkItem(0, src, 0));
        
        var result = -1;
        
        while (work.size() > 0) {
            var workItem = work.poll();
            
            if (workItem.node == dst) {
                return workItem.totalCost;
            }

            if (workItem.step <= K && nodes.containsKey(workItem.node)) {
                for (var neighborAndCost : nodes.get(workItem.node).entrySet()) {
                    var neighbor = neighborAndCost.getKey();
                    var cost = neighborAndCost.getValue();

                    if (
                        !costs.containsKey(neighbor) ||
                        costs.get(neighbor) > workItem.totalCost + cost
                    ) {
                        work.add(new WorkItem(
                            workItem.step + 1,
                            neighbor,
                            workItem.totalCost + cost
                        ));
                        costs.put(neighbor, workItem.totalCost + cost);
                    } else if (!steps.containsKey(neighbor) || steps.get(neighbor) > workItem.step + 1) {
                        work.add(new WorkItem(
                            workItem.step + 1,
                            neighbor,
                            workItem.totalCost + cost
                        ));
                        steps.put(neighbor, workItem.step + 1);
                    }
                }
            }
        }
        
        return -1;
    }
}

class WorkItem {
    int step;
    int node;
    int totalCost;
    
    WorkItem(int s, int n, int t) {
        step = s;
        node = n;
        totalCost = t;
    }
}
