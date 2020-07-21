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
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = head;

        while (head != null && head.val == val) {
            head = head.next;
            start = head;
        }

        if (head == null) {
            return head;
        }

        while (head != null) {
            if (head.next != null) {
                if (head.next.val == val) {
                    head.next = head.next.next;
                } else {
                    head = head.next;
                }
            } else {
                head = null;
            }
        }

        return start;
    }
}
