package Algorithm.Test.LeetCode;

/**
 * Given a string, find the length of the longest substring
 * without repeating characters.
 * For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */


import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters
{
    public static int lengthOfLongestSubstring(String s)
    {
        Map<Character,Integer> m = new HashMap<Character,Integer>();

        int g = 0;
        int begin = 0;
        int l = 0;

        for (int i = 0; i < s.length(); ++i)
        {
            if (!m.containsKey(s.charAt(i)))
            {
                m.put(s.charAt(i),i);
                ++l;
                g = (l > g) ? l : g;
            }
            else
            {
                int p = m.get(s.charAt(i));
                if (p < begin)
                {
                    m.put(s.charAt(i),i);
                    ++l;
                    g = (l > g) ? l : g;
                }
                else
                {
                    begin = p+1;
                    l = i-begin+1;
                    m.put(s.charAt(i),i);
                }
            }
        }

        return g;
    }
}
