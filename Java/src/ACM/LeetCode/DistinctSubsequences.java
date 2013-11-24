package ACM.LeetCode;

/**
 * Given a string S and a string T,
 * count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string
 * which is formed from the original string
 * by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 */

public class DistinctSubsequences
{
    public int numDistinct(String S, String T)
    {
        int s = S.length();
        int t = T.length();

        int[][] dp = new int[s+1][t+1];

        for (int i = 0; i <= s; ++i)
        {
            for (int j = 0; j <= t; ++j)
            {
                if (i == 0)
                {
                    dp[i][j] = 0;
                    break;
                }
                if (j == 0)
                {
                    dp[i][j] = 1;
                    break;
                }

                dp[i][j] = dp[i-1][j];
                if (S.charAt(i-1) == T.charAt(j-1))
                    dp[i][j] += dp[i-1][j-1];
            }
        }

        return dp[s][t];
    }
}
