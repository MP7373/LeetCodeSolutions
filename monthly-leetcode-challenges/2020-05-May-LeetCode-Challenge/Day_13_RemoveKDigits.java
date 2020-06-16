class Solution {
    public String removeKdigits(String num, int k) {
        System.out.println("str len " + num.length());
        System.out.println("k " + k);
        if (num.length() == k) {
            return "0";
        }

        var q = new PriorityQueue<ValIndex>(num.length(), (a, b) -> a.val != b.val ? a.val - b.val : a.index - b.index);
        var len = num.length() - k;
        
        for (var i = 0; i < num.length() - (len - 1); i++) {
            var c = num.charAt(i);

            q.add(new ValIndex(Integer.parseInt(c + ""), i));
        }
        
        var left = 0;
        var right = num.length();
        var s = "";
        
        var count = len;

        for (var i = num.length() - (len - 1); i < num.length(); i++) {
            System.out.println("size " + q.size());
            while (q.peek().index < left) {
                System.out.println("size " + q.size());
                System.out.println(q.poll().val);
            }

            var n = q.poll();
            left = n.index + 1;

            System.out.println(n.val);
            
            s += n.val;
            
            var c = num.charAt(i);

            q.add(new ValIndex(Integer.parseInt(c + ""), i));
            
            count--;
        }
        
        while (count > 0) {
            System.out.println("size " + q.size());
            while (q.peek().index < left) {
                System.out.println("size " + q.size());
                System.out.println(q.poll().val);
            }

            var n = q.poll();
            System.out.println(n.val);
            left = n.index + 1;

            s += n.val;
            
            count--;
        }
        
        var start = 0;
        while (s.charAt(start) == '0') {
            start++;
            if (start == s.length()) {
                return "0";
            }
        }
        
        return s.substring(start);
    }
}

class ValIndex {
    int val;
    int index;
    
    ValIndex(int v, int i) {
        val = v;
        index = i;
    }
}