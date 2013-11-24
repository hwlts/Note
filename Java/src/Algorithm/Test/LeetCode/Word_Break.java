package Algorithm.Test.LeetCode;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into
 * a space-separated sequence of one or more dictionary words.
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */

public class Word_Break
{
    public boolean wordBreak(String s, Set<String> dict)
    {
        if (null == s || null == dict)
            return false;

        int len = s.length();
        boolean[][] dp = new boolean[len][];

        for (int i = 0; i < len; ++i)
            dp[i] = new boolean[len-i];

        for (int i = 0; i < len; ++i)
            dp[i][0] = (dict.contains(s.substring(i,i+1)));

        for (int i = len-2; i >= 0; --i)
        {
            for (int j = 1; j < len-i; ++j)
            {
                dp[i][j] = false;

                if (dict.contains(s.substring(i,i+j+1)))
                {
                    dp[i][j] = true;
                    continue;
                }

                for (int k = 1; k <= j; ++k)
                {
                    if (dp[i][k-1] && dp[i+k][j-k])
                    {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }

        return dp[0][len-1];
    }
}
