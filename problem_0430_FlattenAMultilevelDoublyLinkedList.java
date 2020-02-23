// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

class Solution {

  public Node flatten(Node head) {
      Node originalHead = head;
      
      flattenLayers(head);

      return originalHead;
  }
  
  private static Node flattenLayers(Node head) {
      if (head == null) {
          return null;
      }

      while (head != null && (head.next != null || head.child != null)) {
          if (head.child != null) {
              Node endOfFlattenedLayers = flattenLayers(head.child);
              
              Node next = head.next;

              head.next = head.child;
              head.next.prev = head;
              head.child = null;
              
              endOfFlattenedLayers.next = next;
              
              head = endOfFlattenedLayers;
          } else {
              head.next.prev = head;
              head = head.next;
          }
      }

      return head;
  }
}
