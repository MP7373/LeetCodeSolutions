/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public ListNode ReverseKGroup(ListNode head, int k)
    {
        var heads = new List<ListNode>();
        var tails = new List<ListNode>();
        
        var len = GetListLength(head, 0);
        
        var steps = len / k;
        var step = 0;
        ListNode last = null;
        while (step < steps)
        {
            heads.Add(head);
            (last, head) = ReverseSegment((last, head), 1, k);
            tails.Add(last);
            
            step++;
        }
        
        tails.Add(head);
        
        for (var i = 1; i < tails.Count; i++)
        {
            heads[i - 1].next = tails[i];
        }
        
        return tails[0];
    }
    
    private int GetListLength(ListNode node, int len)
    {
        if (node == null)
        {
            return len;
        }
        
        return GetListLength(node.next, len + 1);
    }
    
    private (ListNode last, ListNode node) ReverseSegment((ListNode last, ListNode node) lastAndNode, int n, int k)
    {
        var last = lastAndNode.last;
        var node = lastAndNode.node;

        if (node == null)
        {
            return (null, null);
        }
        
        var next = node.next;
        node.next = last;
        
        if (n >= k)
        {
            return (node, next);
        }
        
        return ReverseSegment((node, next), n + 1, k);
    }
}
