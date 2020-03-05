class Solution {
    public int calculate(String s) {
        int value = 0;
        boolean plus = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                IntTuple res = eval(s, i + 1);
                if (plus) {
                    value += res.a;
                } else {
                    value -= res.a;
                    plus = true;
                }
                i = res.b;
            } else if (c == ')') {
                return value;
            } else if (c == '+') {
                
            } else if (c == '-') {
                plus = !plus;
            } else if (c == ' ') {
                
            } else {
                int j = 0;
                for (j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) < '0' || s.charAt(j) > '9') {
                        break;
                    }
                }
                if (plus) {
                    value += Integer.parseInt(String.valueOf(
                        s.substring(i, j)
                    ));
                } else {
                    value -= Integer.parseInt(String.valueOf(
                        s.substring(i, j)
                    ));
                    plus = true;
                }
                i = j - 1;
            }
            
        }
        
        return value;
    }
    
    private IntTuple eval(String s, int index) {
        int value = 0;
        boolean plus = true;

        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                IntTuple res = eval(s, i + 1);
                if (plus) {
                    value += res.a;
                } else {
                    value -= res.a;
                    plus = true;
                }
                i = res.b;
            } else if (c == ')') {
                return new IntTuple(value, i);
            } else if (c == '+') {
                
            } else if (c == '-') {
                plus = !plus;
            } else if (c == ' ') {
                
            } else {
                int j = 0;
                for (j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) < '0' || s.charAt(j) > '9') {
                        break;
                    }
                }
                if (plus) {
                    value += Integer.parseInt(String.valueOf(
                        s.substring(i, j)
                    ));
                } else {
                    value -= Integer.parseInt(String.valueOf(
                        s.substring(i, j)
                    ));
                    plus = true;
                }
                i = j - 1;
            }
        }
        
        return new IntTuple(value, s.length());
    }
}

class IntTuple {
    int a;
    int b;
    
    IntTuple(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
