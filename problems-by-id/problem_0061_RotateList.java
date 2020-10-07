/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        var node = head;
        var tail = head;
        var len = 0;

        while (node != null) {
            len++;

            if (node.next == null) {
                tail = node;
            }

            node = node.next;
        }

        tail.next = head;
        var shift = k % len;
        node = head;

        for (var i = 0; i < (len - shift); i++) {
            tail = node;
            node = node.next;
        }

        tail.next = null;

        return node;

    }
}
