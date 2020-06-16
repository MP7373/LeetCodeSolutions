/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool IsInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     int GetInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     IList<NestedInteger> GetList();
 * }
 */
public class NestedIterator
{
    
    private List<int> list;
    private int listIndex = 0;

    public NestedIterator(IList<NestedInteger> nestedList)
    {
        list = new List<int>();
        
        Flatten(nestedList);
    }
    
    private void Flatten(IList<NestedInteger> nestedList)
    {
        foreach (var item in nestedList)
        {
            if (item.IsInteger())
            {
                list.Add(item.GetInteger());
            }
            else
            {
                Flatten(item.GetList());
            }
        }
    }

    public bool HasNext()
    {
        return listIndex < list.Count;
    }

    public int Next()
    {
        return list[listIndex++];
    }
}

/**
 * Your NestedIterator will be called like this:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.HasNext()) v[f()] = i.Next();
 */
 