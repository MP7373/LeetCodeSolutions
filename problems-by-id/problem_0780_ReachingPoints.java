class Solution {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        
        while (tx >= sx && ty >= sy) {
            if (tx == ty) {
                return tx == sx && ty == sy;
            }
            
            if (tx > ty) {
                if (ty > sy) {
                    tx %= ty;
                } else {
                    return (tx - sx) % sy == 0;
                }
            } else {
                if (tx > sx) {
                    ty %= tx;
                } else {
                    return (ty - sy) % sx == 0;
                }
            }
        }
        
        return tx == sx && ty == sy;
    }
}
