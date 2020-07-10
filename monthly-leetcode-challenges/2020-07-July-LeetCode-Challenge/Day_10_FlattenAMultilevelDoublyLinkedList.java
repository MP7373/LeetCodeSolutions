/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        var finalHead = head;

        while (head != null) {
            if (head.child == null) {
                head = head.next;
            } else {
                var next = head.next;
                head.next = head.child;
                head.next.prev = head;
                head.child = null;

                head = flattenNextLevel(head.next, next);
            }
        }

        return finalHead;
    }

    public Node flattenNextLevel(Node head, Node next) {
        while (head != null) {
            if (head.child == null) {
                if (head.next == null) {
                    head.next = next;

                    if (next != null) {
                        next.prev = head;
                    }

                    return next;
                }

                head = head.next;
            } else {
                var nextNode = head.next;
                head.next = head.child;
                head.next.prev = head;
                head.child = null;

                head = flattenNextLevel(head.next, nextNode);
                if (head == null) {
                    return null;
                }
            }

            if (head.next == null) {
                head.next = next;

                if (next != null) {
                    next.prev = head;
                }

                return next;
            }
        }

        return null;
    }
}
