class RandomizedSet {
    private final Map<Integer, Integer> map = new HashMap<>();
    private final List<Integer> list = new ArrayList<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);

            return true;
        }

        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if (map.containsKey(val)) {
            var index = map.get(val);
            var endOfListIndex = list.size() - 1;
            var valAtEndOfList = list.get(endOfListIndex);

            list.set(index, valAtEndOfList);
            map.put(valAtEndOfList, index);
            list.remove(endOfListIndex);
            map.remove(val);
            
            return true;
        }

        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get((int) (Math.random() * (double) list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
 