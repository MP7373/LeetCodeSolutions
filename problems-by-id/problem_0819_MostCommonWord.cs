using System.Text.RegularExpressions;

public class Solution {
    public string MostCommonWord(string paragraph, string[] banned)
    {
        var set = new HashSet<string>();
        foreach (var bannedWord in banned)
        {
            set.Add(bannedWord);
        }

        var regex = new Regex(@"[a-zA-Z]+");
        var counts = new Dictionary<string, int>();

        foreach (Match match in regex.Matches(paragraph))
        {
            var word = match.Value.ToLower();
            if (!banned.Contains(word))
            {
                if (!counts.ContainsKey(word))
                {
                    counts.Add(word, 1);
                }
                else
                {
                    counts[word]++;
                }
            }
        }

        var mostCommon = "";
        var mostCommonCount = 0;
        foreach (var keyVal in counts)
        {
            if (keyVal.Value > mostCommonCount)
            {
                mostCommon = keyVal.Key;
                mostCommonCount = keyVal.Value;
            }
        }

        return mostCommon;
    }
}
