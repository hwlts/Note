package Algorithm.Test;

public class LCS
{
    /**
     * 最长公共子串
     */

    public static int LongestCommonSubString(String x, String y)
    {
        int max = 0;

        int m = x.length();
        int n = y.length();

        /**
         * dp[i][j]表示分别以x[i]，y[j]结尾的公共子串的长度
         */
        int[][] dp = new int [m][n];

        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if (x.charAt(i) == y.charAt(j))
                {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i-1][j-1] + 1;

                    max = (max > dp[i][j]) ? max : dp[i][j];
                }
            }
        }

        return max;
    }


    /**
     * 最长公共子序列
     */

    public static int LongestCommonSubSequence(String x, String y)
    {
        int m = x.length();
        int n = y.length();

        /**
         * dp[i][j]表示x,y长度分别为i,j时的公共子序列的长度
         */
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; ++i)
        {
            for (int j = 0; j <= n; ++j)
            {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                {
                    if (x.charAt(i-1) == y.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args)
    {
        String x = "abcbdab";
        String y = "bdcaba";
        System.out.println(LongestCommonSubString(x,y));
        System.out.println(LongestCommonSubSequence(x,y));
    }
}
