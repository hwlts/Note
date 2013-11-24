package ACM.LeetCode;

/**
 * Say you have an array for which
 * the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */

public class ContainerWithMostWater
{
    public int maxArea(int[] height)
    {
        int begin = 0;
        int end = height.length-1;

        int g_Area = 0;
        int g_Height = 0;
        while (begin < end)
        {
            int l_Height = (height[begin] < height[end]) ? height[begin] : height[end];
            if (l_Height > g_Height)
            {
                int l_Area = l_Height*(end-begin);
                g_Area = (l_Area>g_Area) ? l_Area : g_Area;
                g_Height = l_Height;
            }

            if (height[begin] < height[end])
                ++begin;
            else
                --end;
        }

        return g_Area;
    }
}
