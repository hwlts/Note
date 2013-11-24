package ACM.LeetCode;

/**
 * Given s1, s2, s3,
 * find whether s3 is formed by the interleaving of s1 and s2.
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */

public class InterleavingString
{
    public boolean isInterleave(String s1, String s2, String s3)
    {
        if (s1 == null || s2 == null || s3 == null)
            return false;

        if (s3.length() != s1.length() + s2.length())
            return false;

        int m = s1.length()+1;
        int n = s2.length()+1;

        boolean[][] dp = new boolean[m][n];

        dp[0][0] = true;

        int i = 1;
        while (i < m)
        {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
            ++i;
        }

        i = 1;
        while (i < n)
        {
            dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
            ++i;
        }

        i = 1;

        while (i < m)
        {
            int j = 1;
            while (j < n)
            {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                ++j;
            }
            ++i;
        }

        return dp[m-1][n-1];
    }
}
