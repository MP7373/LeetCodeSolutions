class Solution {
    public double angleClock(int hour, int minutes) {
        var difference = Math.abs(getMinuteAngle(minutes) - getHourAngle(hour, minutes));
        return Math.min(difference, 360 - difference);
    }

    private double getMinuteAngle(int minutes) {
        return 360 * minutes / 60.0;
    }

    private double getHourAngle(int hour, int minutes) {
        double hours = hour + minutes / 60.0;

        if (hours >= 12) {
            hours -= 12;
        }

        return 360 * hours / 12;
    }
}
