package Algorithm.Test.LeetCode;

/**
 * Returns a pointer to the first occurrence of needle in haystack,
 * or null if needle is not part of haystack.
 */

/**
 * To be revised by KMP.
 * */

public class Implement_strStr
{
    /**
     * strStr_old(m,n), O(m+n) Complexity by KMP.
     */

    public String strStr(String haystack, String needle)
    {
        return null;
    }

    /**
     * strStr_old(m,n) , O(m*n) Complexity.
     */
    public String strStr_old(String haystack, String needle)
    {
        int len_haystack = haystack.length();
        int len_needle = needle.length();

        if (len_needle > len_haystack)
            return null;

        int i = 0;
        while(i <= len_haystack-len_needle)
        {
            int j = 0;
            while (j < len_needle)
            {
                if (needle.charAt(j) != haystack.charAt(i+j))
                    break;
                ++j;
            }
            if (j == len_needle)
                return haystack.substring(i);
            ++i;
        }

        return null;
    }
}
