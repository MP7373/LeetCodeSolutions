public class Solution
{
    public bool IsPalindrome(string s)
    {
        if (s.Length == 0)
        {
            return true;
        }
        
        var leftIndex = 0;
        var rightIndex = s.Length - 1;
        
        while (leftIndex < rightIndex)
        {
            while (!((s[leftIndex] >= 'a' && s[leftIndex] <= 'z')
                   || (s[leftIndex] >= 'A' && s[leftIndex] <= 'Z')
                   || (s[leftIndex] >= '0' && s[leftIndex] <= '9'))
                  && leftIndex < rightIndex)
            {
                leftIndex++;
            }
            
            while (!((s[rightIndex] >= 'a' && s[rightIndex] <= 'z')
                   || (s[rightIndex] >= 'A' && s[rightIndex] <= 'Z')
                   || (s[rightIndex] >= '0' && s[rightIndex] <= '9'))
                  && leftIndex < rightIndex)
            {
                rightIndex--;
            }
            
            if (leftIndex < rightIndex &&
                s[leftIndex] >= 65 && s[rightIndex] >= 65 ?
                ( s[leftIndex] != s[rightIndex]
                 && s[leftIndex] + 32 != s[rightIndex]
                 && s[leftIndex] - 32 != s[rightIndex]
                ) :
                s[leftIndex] != s[rightIndex]
               )
            {
                return false;
            }
            
            leftIndex++;
            rightIndex--;
        }

        return true;
    }
}
