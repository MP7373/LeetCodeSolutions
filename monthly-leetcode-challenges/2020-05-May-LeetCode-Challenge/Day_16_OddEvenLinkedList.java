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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        
        var index = 1;
        while (head != null) {
            if (index % 2 == 1) {
                if (oddTail == null) {
                    oddHead = head;
                    oddTail = head;
                } else {
                    oddTail.next = head;
                    oddTail = head;
                }
            } else {
                if (evenTail == null) {
                    evenHead = head;
                    evenTail = head;
                } else {
                    evenTail.next = head;
                    evenTail = head;
                }
            }
            
            var temp = head.next;
            head.next = null;
            head = temp;
            
            index++;
        }
        
        if (oddTail != null) {
            oddTail.next = evenHead;
            return oddHead;
        }

        return evenHead;
    }
}
