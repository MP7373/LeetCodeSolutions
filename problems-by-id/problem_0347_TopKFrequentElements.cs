public class Solution {
    public IList<int> TopKFrequent(int[] nums, int k) {
        var counts = new Dictionary<int, int>();

        foreach (var num in nums) {
            if (counts.ContainsKey(num)) {
                counts[num]++;
            } else {
                counts.Add(num, 1);
            }
        }

        var pairs = new List<(int num, int count)>();

        foreach (var keyVal in counts) {
            pairs.Add((keyVal.Key, keyVal.Value));
        }

        pairs.Sort((a, b) => b.count - a.count);

        return pairs.Select(pair => pair.num).Take(k).ToList();
    }
}
