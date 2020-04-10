class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 
class Solution {
    public ListNode middleNode(ListNode head) {
        var numberOfNodes = 0;
        var node = head;
        
        while (node != null) {
            numberOfNodes++;
            node = node.next;
        }
        
        var middle = numberOfNodes / 2 + 1;
        var currentNode = 1;
        
        while (currentNode != middle) {
            currentNode++;
            head = head.next;
        }
        
        return head;
    }
}
