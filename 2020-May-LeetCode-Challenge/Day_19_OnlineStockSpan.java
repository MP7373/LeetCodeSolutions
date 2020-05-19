class StockSpanner {
    
    Stack<Tuple> last = new Stack<>();

    public StockSpanner() {
    }
    
    public int next(int price) {
        var priceTuple = new Tuple(price);

        while (last.size() > 0 && price >= last.peek().val) {
            priceTuple.numsBehind += last.peek().numsBehind;
            last.pop();
        }
        
        last.push(priceTuple);
        return priceTuple.numsBehind;
    }
}

class Tuple {
    int val;
    int numsBehind = 1;
    
    Tuple(int v) {
        val = v;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
 