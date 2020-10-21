class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        var stack = new ArrayDeque<Integer>();

        for (var roid : asteroids) {
            stack.push(roid);

            var top = stack.pop();
            while (
                !stack.isEmpty() &&
                top != null &&
                (stack.peek() >= 0 && top < 0)
            ) {
                if (stack.peek() + top > 0) {
                    top = null;
                } else if (stack.peek() + top == 0) {
                    stack.pop();
                    top = null;
                } else {
                    stack.pop();
                }
            }

            if (top != null) {
                stack.push(top);
            }
        }

        var roids = new int[stack.size()];
        for (int i = roids.length - 1; i >= 0; i--) {
            roids[i] = stack.pop();
        }

        return roids;
    }
}
