class Logger {
    private Map<String, Integer> messageTimeoutMap;
    int lastTimestamp;

    /** Initialize your data structure here. */
    public Logger() {
        messageTimeoutMap = new HashMap<>();
        lastTimestamp = -1;
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean shouldPrint = false;

        if (timestamp > lastTimestamp) {
            while (lastTimestamp < timestamp) {
                for (String key : messageTimeoutMap.keySet()) {
                    int timeout = messageTimeoutMap.get(key);
                    messageTimeoutMap.put(key, timeout - 1);
                }

                lastTimestamp++;
            }
        }

        if (!messageTimeoutMap.containsKey(message) || messageTimeoutMap.get(message) < 1) {
            messageTimeoutMap.put(message, 10);
            shouldPrint = true;
        }

        return shouldPrint;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
