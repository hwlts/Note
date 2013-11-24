package ACM.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example, Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

public class MergeIntervals
{
    public static class Interval
    {
        int start;
        int end;

        Interval()
        {
            start = 0;
            end = 0;
        }

        Interval(int s, int e)
        {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals)
    {
        if (intervals == null)
            return null;

        if (intervals.size() == 0 || intervals.size() == 1)
            return intervals;

        Comparator comparator = new Comparator<Interval>()
        {
            @Override
            public int compare(Interval o1, Interval o2)
            {
                if (o1.start != o2.start)
                    return (o1.start < o2.start) ? -1 : ((o1.start == o2.start) ? 0 : 1);
                return (o1.end < o2.end) ? -1 : ((o1.end == o2.end) ? 0 : 1);
            }
        };

        Collections.sort(intervals,comparator);

        ArrayList<Interval> r = new ArrayList<Interval>();

        int g_start = intervals.get(0).start;
        int g_end = intervals.get(0).end;

        int i = 1;

        while (i < intervals.size())
        {
            if (intervals.get(i).start <= g_end)
            {
                g_end = (g_end > intervals.get(i).end) ? g_end : intervals.get(i).end;
                ++i;
                continue;
            }
            else
            {
                r.add(new Interval(g_start,g_end));
                g_start = intervals.get(i).start;
                g_end = intervals.get(i).end;
                ++i;
            }
        }

        r.add(new Interval(g_start,g_end));
        return r;
    }
}
