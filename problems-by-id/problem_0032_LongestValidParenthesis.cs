public class Solution
{
    public int LongestValidParentheses(string s)
    {
        var levelIndexes = new Dictionary<int, int>();

        var index = 0;

        while (index < s.Length && s[index] == ')')
        {
            index++;
        }

        var max = 0;
        var level = 0;
        while (index < s.Length)
        {
            if (s[index] == '(')
            {
                if (!levelIndexes.ContainsKey(level))
                {
                    levelIndexes[level] = index;
                }

                level++;
            }
            else
            {
                levelIndexes.Remove(level);

                level--;

                if (levelIndexes.ContainsKey(level))
                {
                    var len = index - levelIndexes[level] + 1;

                    max = Math.Max(max, len);
                }
            }

            index++;
        }

        return max;
    }
}
