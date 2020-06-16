class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        var slopeAndStartY = getSlopeAndStartY(coordinates[0], coordinates[1]);
        
        for (var i = 2; i < coordinates.length; i++) {
            var slopeAndStartBetweenPoints = getSlopeAndStartY(coordinates[i - 1], coordinates[i]);
            
            if (!(slopeAndStartBetweenPoints.a == slopeAndStartY.a &&
                 slopeAndStartBetweenPoints.b == slopeAndStartY.b)) {
                return false;
            }
        }
        
        return true;
    }
    
    private Tuple getSlopeAndStartY(int[] coord1, int[] coord2) {
        double xDif = coord2[0] - coord1[0];
        double yDif = coord2[1] - coord1[1];
        double slope = xDif == 0 ? 0 : yDif / xDif;
        double startY = slope * -coord1[0] + coord1[1];
        
        return new Tuple(slope, startY);
    }
}

class Tuple {
    double a;
    double b;
    
    Tuple(double a, double b) {
        this.a = a;
        this.b = b;
    }
}
