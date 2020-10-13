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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var leftTail = new ListNode();
        leftTail.next = head;
        var mid = head;
        var bunny = mid.next;

        while (bunny != null) {
            leftTail = mid;
            mid = mid.next;
            bunny = bunny.next;

            if (bunny != null) {
                bunny = bunny.next;
            }
        }
        leftTail.next = null;

        return merge(sortList(head), sortList(mid));
    }

    private ListNode merge(ListNode a, ListNode b) {
        var node = new ListNode();
        var head = node;

        while (a != null || b != null) {
            if (a != null && b != null) {
                if (a.val <= b.val) {
                    node.next = a;
                    a = a.next;
                } else {
                    node.next = b;
                    b = b.next;
                }
            } else if (a != null) {
                node.next = a;
                a = a.next;
            } else {
                node.next = b;
                b = b.next;
            }

            node = node.next;
        }

        return head.next;
    }
}
