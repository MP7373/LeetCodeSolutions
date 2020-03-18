public class MyHashMap
{
    private int[] table;

    /** Initialize your data structure here. */
    public MyHashMap()
    {
        table = new int[1000001];
        for (var i = 0; i < table.Length; i++)
        {
            table[i] = -1;
        }
    }

    /** value will always be non-negative. */
    public void Put(int key, int value)
    {
        table[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int Get(int key)
    {
        return table[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void Remove(int key)
    {
        table[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key,value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */
