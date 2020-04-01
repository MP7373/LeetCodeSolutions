public class Solution
{
    public int SingleNumber(int[] nums)
    {
        var set = new HashSet<int>();

        foreach (var num in nums)
        {
            if (!set.Contains(num))
            {
                set.Add(num);
            }
            else
            {
                set.Remove(num);
            }
        }

        foreach (var num in set)
        {
            return num;
        }

        return -1;
    }
}
