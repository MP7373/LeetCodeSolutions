class Solution {
  public int[] findPermutation(String s) {
      int n = s.length() + 1;

      int[] decreasingSequenceTable = new int[n];
      int decreasingSequenceLength = 0;
      for (int i = n - 2; i >= 0; i--) {
          if (s.charAt(i) == 'D') {
              decreasingSequenceLength++;
          } else {
              decreasingSequenceLength = 0;
          }

          decreasingSequenceTable[i] = decreasingSequenceLength;
      }

      DoublyLinkedListNode head = new DoublyLinkedListNode(1, null, null);
      DoublyLinkedListNode nodeRef = head;
      for (int i = 2; i <= n; i++) {
          DoublyLinkedListNode newNode = new DoublyLinkedListNode(i, nodeRef, null);
          nodeRef.next = newNode;
          nodeRef = newNode;
      }

      int[] perm = new int[n];
      return createPermutation(s, perm, 0, head, 0, decreasingSequenceTable) ? perm : null;
  }

  private boolean createPermutation(
      String s,
      int[] perm,
      int index,
      DoublyLinkedListNode numsHead,
      int last,
      int[] decreasingSequenceTable
  ) {
      if (index >= perm.length) {
          return true;
      }

      int sIndex = index - 1;
      DoublyLinkedListNode node = numsHead;
      int nodesSmallerThanCurrent = 0;
      while (node != null) {
          if (
              nodesSmallerThanCurrent >= decreasingSequenceTable[index] &&
              (sIndex == -1 ||
              (s.charAt(sIndex) == 'I' && node.val > last) ||
              (s.charAt(sIndex) == 'D' && node.val < last))
          ) {
              perm[index] = node.val;

              if (node.last != null) {
                  node.last.next = node.next;
              }

              if (node.next != null) {
                  node.next.last = node.last;
              }

              DoublyLinkedListNode nextHead = node == numsHead ? numsHead.next : numsHead;
              if (createPermutation(s, perm, index + 1, nextHead, node.val, decreasingSequenceTable)) {
                  return true;
              }

              if (node.last != null) {
                  node.last.next = node;
              }

              if (node.next != null) {
                  node.next.last = node;
              }
          }

          if (sIndex >= 0 && s.charAt(sIndex) == 'D' && node.val >= last) {
              return false;
          }

          node = node.next;
          nodesSmallerThanCurrent++;
      }

      return false;
  }
}

class DoublyLinkedListNode {
  int val;
  DoublyLinkedListNode last;
  DoublyLinkedListNode next;

  DoublyLinkedListNode(int val, DoublyLinkedListNode last, DoublyLinkedListNode next) {
      this.val = val;
      this.last = last;
      this.next = next;
  }
}
