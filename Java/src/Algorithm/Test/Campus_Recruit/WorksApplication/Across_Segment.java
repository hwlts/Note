package Algorithm.Test.Campus_Recruit.WorksApplication;

/**
 * 判断两个线段是否相交
 */

public class Across_Segment
{
    public static class Segment
    {
        int begin;
        int end;
    }

    public boolean isCross(Segment s1, Segment s2)
    {
        return (s1.begin-s2.begin)*(s1.end-s2.end) <= 0;
    }
}

