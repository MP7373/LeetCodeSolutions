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
  public boolean isPalindrome(ListNode last) {
      if (last == null) {
          return true;
      }

      ListNode l = last;
      ListNode fast = l.next;
      last = null;
      ListNode cur;

      while (fast != null) {
          fast = fast.next;

          if (fast != null) {
              fast = fast.next;

              if (fast != null) {
                  cur = l;
                  l = l.next;
                  cur.next = last;
                  last = cur;
              } else {
                  fast = l.next.next;
                  l.next = last;
                  break;
              }
          } else {
              if (fast != null) {
                  cur = l;
                  l = l.next;
                  cur.next = last;
                  last = cur;
              } else {
                  fast = l.next;
                  l.next = last;
                  break;
              }
          }
      }

      if (l != null && fast == null) {
          return true;
      }

      while (l != null && fast != null) {
          if (l.val != fast.val) {
              return false;
          }

          l = l.next;
          fast = fast.next;
      }

      return true;
  }
}
