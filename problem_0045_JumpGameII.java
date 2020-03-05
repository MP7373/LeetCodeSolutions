import java.util.*;

class Solution {
    
    private static final int BIG_NUMBER = Integer.MAX_VALUE - 1000;

    public int jump(int[] nums) {
        return numberOfJumps(nums, 0, new HashMap<>()) - 1;
    }
    
    private static int numberOfJumps(
        int[] nums,
        int index,
        Map<Integer, Integer> minJumpsMap
    ) {
        if (index >= nums.length
           || (index != nums.length - 1 && nums[index] == 0)
           ) {
            return BIG_NUMBER;
        }
        
        if (index == nums.length - 1) {
            return 1;
        }

        if (minJumpsMap.containsKey(index)) {
            return minJumpsMap.get(index) + 1;
        }
        
        int minJumpsFromHere = BIG_NUMBER;
        
        PriorityQueue<NumTuple> q = new PriorityQueue<>(100, (a, b) ->
            b.a - a.a != 0 ? b.a - a.a : b.b - a.b);
        for (int i = nums[index]; i > 0 ; i--) {
            if (index + i >= nums.length - 1) {
                q.add(new NumTuple(nums.length - 1, index + i));
            } else if (index + i  + nums[index + i] >= nums.length - 1) {
                q.add(new NumTuple(nums.length - 1, index + i));
            } else {
                q.add(new NumTuple(index + i + nums[index + i], index + i));   
            }
        }
        
        while (!q.isEmpty()) {
            NumTuple tup = q.poll();
            int nextIndex = tup.b;
            System.out.println("-" + index + " - " + tup.a + " - " + tup.b);
            
            int jumps = numberOfJumps(
                nums,
                nextIndex,
                minJumpsMap
            );
            
            if (jumps < minJumpsFromHere) {
                minJumpsFromHere = jumps;
                break;
            }
        }
        
        minJumpsMap.put(index, minJumpsFromHere);

        return minJumpsFromHere + 1;
    }
}

class NumTuple {
    int a;
    int b;
    
    NumTuple(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
