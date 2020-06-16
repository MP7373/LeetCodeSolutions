class FirstUnique {
    
    DoublyLinkedInteger firstUnique = null;
    DoublyLinkedInteger lastUnique = null;
    Map<Integer, DoublyLinkedInteger> countMap = new HashMap<>();

    public FirstUnique(int[] nums) {
        for (var num : nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        return firstUnique == null ? -1 : firstUnique.val;
    }
    
    public void add(int value) {
       if (!countMap.containsKey(value)) {
            var linkedNum = new DoublyLinkedInteger(null, null, value);

            countMap.put(value, linkedNum);

            if (firstUnique == null) {
                firstUnique = linkedNum;
                lastUnique = linkedNum;
            } else {
                linkedNum.prev = lastUnique;
                
                lastUnique.next = linkedNum;

                lastUnique = linkedNum;
            }
        } else if (countMap.get(value) != null) {
            var alreadyUsedLinkedNum = countMap.get(value);

            if (alreadyUsedLinkedNum == firstUnique && alreadyUsedLinkedNum == lastUnique) {
                firstUnique = null;
                lastUnique = null;
            } else if (alreadyUsedLinkedNum == firstUnique) {
                firstUnique = firstUnique.next;

                if (firstUnique != null) {
                    firstUnique.prev = null;
                }
            } else if (alreadyUsedLinkedNum == lastUnique) {
                lastUnique = lastUnique.prev;

                if (lastUnique != null) {
                    lastUnique.next = null;
                }
            } else {
                if (alreadyUsedLinkedNum.prev != null) {
                    alreadyUsedLinkedNum.prev.next = alreadyUsedLinkedNum.next;
                }
                
                if (alreadyUsedLinkedNum.next != null) {
                    alreadyUsedLinkedNum.next.prev = alreadyUsedLinkedNum.prev;
                }
            }
           
            alreadyUsedLinkedNum = null;
            countMap.put(value, null);
        }
    }
}

class DoublyLinkedInteger {
    DoublyLinkedInteger prev;
    DoublyLinkedInteger next;
    int val;
    
    DoublyLinkedInteger(DoublyLinkedInteger prev, DoublyLinkedInteger next, int val) {
        this.prev = prev;
        this.next = next;
        this.val = val;
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */