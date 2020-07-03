class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        long hash = 0L;
        var patterns = new HashMap<Long, Integer>();
        
        for (var i = 0; i < cells.length; i++) {
            hash += cells[i] * Math.pow(10, i);
        }
        patterns.put(hash, 0);

        var notFound = true;
        for (var i = 0; i < N; i++) {
            hash = 0L;
            var last = cells[0];
            cells[0] = 0;
            
            for (var j = 1; j < cells.length - 1; j++) {
                if (last == cells[j + 1]) {
                    last = cells[j];
                    cells[j] = 1;
                } else {
                    last = cells[j];
                    cells[j] = 0;
                }
                
                hash += cells[j] * Math.pow(10, j);
            }
            
            cells[cells.length - 1] = 0;
            
            if (notFound && patterns.containsKey(hash)) {
                notFound = false;

                var loopLength = (i + 1 - patterns.get(hash));
                var stepsLeft = N - (i + 1);
                stepsLeft %= loopLength;
                
                i = 0;
                N = stepsLeft + 1;
            }
            
            if (notFound) {
                patterns.put(hash, i + 1);
            }
        }
        
        return cells;
    }
}
