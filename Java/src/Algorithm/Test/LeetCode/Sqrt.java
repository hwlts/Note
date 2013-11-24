package Algorithm.Test.LeetCode;

import java.math.BigInteger;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */

public class Sqrt
{
    public int sqrt(int x)
    {
        final int MaxResult = 46340;    //sqrt(2pow(32)-1)的结果

        if (x <= 0)
            return 0;

        if (x <= 3)
            return 1;

        int a = 1, b = MaxResult;
        if (x >= b*b)
            return b;

        while (b-a > 1)
        {
            int t = (a+b)/2;
            int f = t*t - x;
            if (f < 0)
                a = t;
            else if (0 == f)
                return t;
            else
                b = t;
        }

        return a;
    }

    public static void main(String[] args)
    {
        Sqrt s = new Sqrt();
        System.out.println(s.sqrt(2147483647));
    }
}
