package Algorithm.Test.LeetCode;

import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals,
 * insert a new interval into the intervals (merge if necessary).
 * You may assume that
 * the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Given intervals [1,3],[6,9],
 * insert and merge [2,5] in as [1,5],[6,9].
 *
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16],
 * insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

public class Insert_Interval
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

    public boolean isEqual(Interval v1, Interval v2)
    {
        return v1.start == v1.end && v1.end == v2.end;
    }

    public boolean isMerge(Interval v1, Interval v2)
    {
        return (v1.start-v2.end)*(v1.end-v2.start) <= 0;
    }

    public Interval Merge(Interval v1, Interval v2)
    {
        return new Interval(Math.min(v1.start,v2.start),Math.max(v1.end,v2.end));
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
    {
        if (null == newInterval)
            return intervals;

        if (null == intervals || 0 == intervals.size())
        {
            ArrayList<Interval> r = new ArrayList<Interval>();
            r.add(newInterval);
            return r;
        }

        if (newInterval.end < intervals.get(0).start)
        {
            intervals.add(0,newInterval);
            return intervals;
        }

        if (newInterval.start > intervals.get(intervals.size()-1).end)
        {
            intervals.add(newInterval);
            return intervals;
        }

        int index = 0,m = -1, n = -1, len = intervals.size();
        boolean flag_m = false;
        while(index < len)
        {
            Interval c = intervals.get(index);
            if (c.end < newInterval.start
             && index <= len-2
             && newInterval.end < intervals.get(index+1).start )
            {
                intervals.add(index+1,newInterval);
                return intervals;
            }

            if (!isMerge(c,newInterval) && !flag_m)
                ++index;
            else if (isMerge(c,newInterval) && !flag_m)
            {
                newInterval = Merge(c,newInterval);
                m = index;
                flag_m = true;
                ++index;
            }
            else if (isMerge(c,newInterval) && flag_m)
            {
                newInterval = Merge(c,newInterval);
                ++index;
            }
            else if (!isMerge(c,newInterval) && flag_m)
            {
                n = index;
                break;
            }
        }

        if (m < 0)
            return intervals;
        else
        {
            n = (n >= 0) ? n : len;
            int r = len - (n-m);
            while(intervals.size() > r)
                intervals.remove(m);
            intervals.add(m,newInterval);
            return intervals;
        }
    }

    public static void main(String[] args)
    {
        Interval v0 = new Interval(1,5);
        Interval v1 = new Interval(6,8);
        Interval v2 = new Interval(5,6);

        ArrayList<Interval> l = new ArrayList<Interval>();
        l.add(v0);
        l.add(v1);

        ArrayList<Interval> r = new Insert_Interval().insert(l,v2);

        System.out.print("");
    }
}
