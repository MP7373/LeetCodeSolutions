/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        var turtle = head;
        var bunny = head;

        while (true) {
            if (turtle == null || turtle.next == null) {
                return null;
            }

            turtle = turtle.next;

            if (bunny == null || bunny.next == null || bunny.next.next == null) {
                return null;
            }

            bunny = bunny.next.next;

            if (turtle == bunny) {
                break;
            }
        }

        var startOfLoop = head;

        while (startOfLoop != turtle) {
            startOfLoop = startOfLoop.next;
            turtle = turtle.next;
        }

        return startOfLoop;
    }
}
