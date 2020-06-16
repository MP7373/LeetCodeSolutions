import java.util.*;

class MedianFinder {
    
    private Queue<Integer> smaller;
    private Queue<Integer> larger;

    /** initialize your data structure here. */
    public MedianFinder() {
        smaller = new PriorityQueue<>(1000, (a, b) -> b - a);
        larger = new PriorityQueue<>(1000, (a, b) -> a - b);
    }
    
    public void addNum(int num) {
        if (smaller.size() <= larger.size()) {
            smaller.add(num);
        } else {
            larger.add(num);
        }
        
        if (smaller.size() != 0 && larger.size() != 0 && smaller.peek() > larger.peek()) {
            int temp = smaller.poll();
            smaller.add(larger.poll());
            larger.add(temp);
        }
    }
    
    public double findMedian() {
        if ((smaller.size() + larger.size()) % 2 == 1) {
            return smaller.size() > larger.size() ? smaller.peek() : larger.peek();
        }
        
        return (smaller.peek() + larger.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
