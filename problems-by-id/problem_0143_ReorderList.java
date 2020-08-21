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
  public void reorderList(ListNode head) {
      if (head == null) {
          return;
      }

      List<ListNode> nodes = new ArrayList<>();

      while (head != null) {
          nodes.add(head);
          head = head.next;
      }

      int mid = nodes.size() / 2;
      int lastNodeIndex = 0;
      for (int i = 0; i < mid; i++) {
          int tailIndex = nodes.size() - 1 - i;

          nodes.get(i).next = nodes.get(tailIndex);
          lastNodeIndex = tailIndex;

          if (i + 1 <= mid && tailIndex != i + 1) {
              nodes.get(tailIndex).next = nodes.get(i + 1);
              lastNodeIndex = i + 1;
          }
      }

      nodes.get(lastNodeIndex).next = null;
  }
}
