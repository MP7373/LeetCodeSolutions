class MyHashSet {
    private static int numberOfBuckets = 3079;

    private LinkedList[] buckets;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new LinkedList[numberOfBuckets];
        Arrays.fill(buckets, new LinkedList());
    }

    public void add(int key) {
        int hash = hash(key);

        if (buckets[hash].indexOf(key) == -1) {
            buckets[hash].add(key);
        }
    }

    public void remove(int key) {
        buckets[hash(key)].remove((Integer) key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return buckets[hash(key)].contains(key);
    }

    private int hash(int key) {
        return key % numberOfBuckets;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
