class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {        
        Map<String, LinkedList<String>> orginToDestinationsMap = new HashMap<>();

        for (List<String> ticket : tickets) {
            if (!orginToDestinationsMap.containsKey(ticket.get(0))) {
                LinkedList<String> destinations = new LinkedList<>();
                destinations.add(ticket.get(1));
                orginToDestinationsMap.put(ticket.get(0), destinations);
            } else {
                orginToDestinationsMap.get(ticket.get(0)).add(ticket.get(1));
            }
        }
        
        Map<String, boolean[]> usedTable = new HashMap<>();
        for (Map.Entry<String, LinkedList<String>> entry : orginToDestinationsMap.entrySet()) {
            Collections.sort(entry.getValue());
            usedTable.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }
        
        LinkedList<String> result = new LinkedList<>();
        result.add("JFK");
        
        backtrack(orginToDestinationsMap, usedTable, result, tickets.size() + 1);
        
        return result;
    }
    
    
    private static boolean backtrack(
        final Map<String, LinkedList<String>> orginToDestinationsMap,
        final Map<String, boolean[]> visitedTable,
        final LinkedList<String> routeSoFar,
        final int goalLength
    ) {
        if (routeSoFar.size() == goalLength) {
            return true;
        }

        String origin = routeSoFar.peekLast();
        if (!orginToDestinationsMap.containsKey(origin)) {
            return false;
        }
        
        LinkedList<String> possibleDestinations = orginToDestinationsMap.get(origin);
        boolean[] originsVisitedTable = visitedTable.get(origin);
        int visitedTableIndex = 0;
        for (String destination : possibleDestinations) {
            if (!originsVisitedTable[visitedTableIndex]) {
                originsVisitedTable[visitedTableIndex] = true;
                routeSoFar.add(destination);
                
                boolean fullRouteWasFound = backtrack(
                    orginToDestinationsMap,
                    visitedTable,
                    routeSoFar,
                    goalLength
                );
                
                if (fullRouteWasFound) {
                    return true;
                }
                
                originsVisitedTable[visitedTableIndex] = false;
                routeSoFar.removeLast();
            }

            visitedTableIndex++;
        }
        
        return false;
    }
}
