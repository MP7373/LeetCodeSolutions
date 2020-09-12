class Solution {
  public boolean checkStraightLine(int[][] coordinates) {
      var slopeAndStartY = getSlopeAndStartY(coordinates[0], coordinates[1]);

      for (var i = 2; i < coordinates.length; i++) {
          var slopeAndStartYFromCurrentAndLastPoints = getSlopeAndStartY(coordinates[i - 1], coordinates[i]);

          if (
             slopeAndStartYFromCurrentAndLastPoints.slope != slopeAndStartY.slope ||
             slopeAndStartYFromCurrentAndLastPoints.startY != slopeAndStartY.startY
          ) {
              return false;
          }
      }

      return true;
  }

  private SlopeStartYTuple getSlopeAndStartY(int[] coord1, int[] coord2) {
      double xDif = coord2[0] - coord1[0];
      if (xDif == 0) {
          return new SlopeStartYTuple(Integer.MAX_VALUE, 0);
      }

      double yDif = coord2[1] - coord1[1];
      double slope = yDif / xDif;
      double startY = slope * -coord1[0] + coord1[1];

      return new SlopeStartYTuple(slope, startY);
  }
}

class SlopeStartYTuple {
  double slope;
  double startY;

  SlopeStartYTuple(double slope, double startY) {
      this.slope = slope;
      this.startY = startY;
  }
}
