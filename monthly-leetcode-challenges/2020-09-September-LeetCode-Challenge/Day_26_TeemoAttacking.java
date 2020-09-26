class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        var poisonedDuration = 0;
        var poisonStartedAt = -1;
        var poisonedUntil = -1;

        for (var time : timeSeries) {
            if (time > poisonedUntil) {
                poisonedDuration += poisonedUntil - poisonStartedAt + 1;
                poisonStartedAt = time;
            }

            poisonedUntil = time + duration - 1;
        }

        poisonedDuration += poisonedUntil - poisonStartedAt;

        return poisonedDuration;
    }
}
