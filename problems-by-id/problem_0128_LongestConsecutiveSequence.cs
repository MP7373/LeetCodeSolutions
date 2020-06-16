public class Solution
{
    public int LongestConsecutive(int[] nums)
    {
        var dict = new Dictionary<int, Node>();
        
        foreach (var n in nums)
        {
            if (!dict.ContainsKey(n))
            {
                if (dict.ContainsKey(n - 1) && dict.ContainsKey(n + 1))
                {
                    var node = new Node
                    {
                        Value = n,
                        Left = dict[n - 1].Left,
                        Right = dict[n + 1].Right
                    };

                    dict.Add(n, node);

                    dict[node.Left].Right = node.Right;
                    dict[node.Right].Left = node.Left;
                }
                else if (dict.ContainsKey(n - 1))
                {
                    var node = new Node
                    {
                        Value = n,
                        Left = dict[n - 1].Left,
                        Right = n
                    };

                    dict.Add(n, node);

                    dict[node.Left].Right = node.Right;
                    dict[node.Right].Left = node.Left;
                }
                else if (dict.ContainsKey(n + 1))
                {
                    var node = new Node
                    {
                        Value = n,
                        Left = n,
                        Right = dict[n + 1].Right
                    };

                    dict.Add(n, node);

                    dict[node.Left].Right = node.Right;
                    dict[node.Right].Left = node.Left;
                }
                else
                {
                    var node = new Node
                    {
                        Value = n,
                        Left = n,
                        Right = n
                    };

                    dict.Add(n, node);

                    dict[node.Left].Right = node.Right;
                    dict[node.Right].Left = node.Left;
                }
            }
        }
        
        int max = 0;
        foreach (var node in dict.Values)
        {
            if (node.Right - node.Left + 1 > max)
            {
                max = node.Right - node.Left + 1;
            }
        }
        
        return max;
    }
}

public class Node
{
    public int Value { get; set; }
    public int Left { get; set; }
    public int Right { get; set; }
}
