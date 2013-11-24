package ACM.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *  [2],
 *  [3,4],
 *  [6,5,7],
 *  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */

public class Triangle
{
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle)
    {
        if (triangle == null || triangle.size() == 0)
            return 0;

        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        List<Integer> dp = new ArrayList<Integer>();
        dp.add(triangle.get(0).get(0));

        List<Integer> t;
        for (int m = 1; m < triangle.size(); ++m)
        {
            t = dp;
            dp = new ArrayList<Integer>();
            dp.add(t.get(0)+triangle.get(m).get(0));
            int n = 1;
            while (n < m)
            {
                dp.add(Math.min(t.get(n-1),t.get(n))+triangle.get(m).get(n));
                ++n;
            }
            dp.add(t.get(t.size()-1)+triangle.get(m).get(triangle.get(m).size()-1));
        }

        int min = dp.get(0);
        for (Integer i : dp)
        {
            min = (i < min) ? i : min;
        }

        return min;
    }
}
