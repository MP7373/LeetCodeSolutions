/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node insertNode = new Node(insertVal);
            insertNode.next = insertNode;

            return insertNode;
        }

        Node last = null;
        Node cur = head;

        while (cur.next.val >= cur.val) {
            last = cur;
            cur = cur.next;

            if (cur == head) {
                break;
            }
        }

        if (cur.val > cur.next.val) {
            last = cur;
            cur = cur.next;
        }
        Node smallest = cur;

        Node insertNode = new Node(insertVal);
        while (insertVal > cur.val) {
            last = cur;
            cur = cur.next;

            if (cur == smallest) {
                last.next = insertNode;
                insertNode.next = cur;
                return head;
            }
        }

        last.next = insertNode;
        insertNode.next = cur;

        return head;
    }
}
