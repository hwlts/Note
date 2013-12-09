package ACM.LeetCode;

import java.util.*;

/**
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 */

public class MaxPointsOnALine
{
    public static class Point
    {
        int x;
        int y;

        Point()
        {
            x = 0;
            y = 0;
        }

        Point(int a, int b)
        {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points)
    {
        int len = points.length;
        if (len < 2)
            return len == 0 ? 0 : 1;
        int max = 0;
        for (int i = 0; i < len; ++i)
        {
            int sameX = 1;
            int samePoint = 0;
            HashMap<Double, Integer> h = new HashMap<Double, Integer>();
            int j = 0;
            while (j < i)
            {
                if (points[i].x == points[j].x && points[i].y == points[j].y)
                {
                    samePoint++;
                    j++;
                    continue;
                }
                if (points[i].x == points[j].x)
                    ++sameX;
                else
                {
                    double r = rate(points[i],points[j]);
                    if (!h.containsKey(r))
                        h.put(r,2);
                    else
                    {
                        int t = h.get(r);
                        h.put(r,t+1);
                    }
                }
                j++;
            }
            j = i + 1;
            while (j < len)
            {
                if (points[i].x == points[j].x && points[i].y == points[j].y)
                {
                    samePoint++;
                    j++;
                    continue;
                }
                if (points[i].x == points[j].x)
                    ++sameX;
                else
                {
                    double r = rate(points[i],points[j]);
                    if (!h.containsKey(r))
                        h.put(r,2);
                    else
                    {
                        int t = h.get(r);
                        h.put(r,t+1);
                    }
                }
                j++;
            }

            int h_max = 1;
            Iterator iter = h.entrySet().iterator();
            while (iter.hasNext())
            {
                Map.Entry entry = (Map.Entry) iter.next();
                int val = (Integer) entry.getValue();
                h_max = val > h_max ? val : h_max;
            }

            int t_max = sameX > h_max ? sameX : h_max;
            max = (t_max + samePoint) > max ? (t_max + samePoint) : max;
        }
        return max;
    }

    public static double rate(Point a, Point b)
    {
        return ((double)a.y-(double)b.y)/((double)a.x-(double)b.x);
    }
}
