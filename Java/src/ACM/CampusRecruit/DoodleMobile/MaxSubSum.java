package ACM.CampusRecruit.DoodleMobile;

import java.util.Arrays;

/**
 * Doodle Mobile 电面
 * 1. 数组最大子序列和
 * 2. 矩阵最大子矩阵和
 * 3. 数组最大不相邻序列和
 */

public class MaxSubSum
{
    public static int MaxSubArraySum(int[] a)
    {
        int sum = Integer.MIN_VALUE;
        int cur = 0;

        for (int i = 0; i < a.length; ++i)
        {
            cur += a[i];
            if (cur > sum)
                sum = cur;

            if (cur < 0)
                cur = 0;
        }

        return sum;
    }

    public static int MaxSubMatrixSum(int[][] a)
    {
        int sum = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; ++i)
        {
            int[] b = new int[a[0].length];
            Arrays.fill(b,0);

            for (int j = i; j < a.length; ++j)
            {
                for (int k = 0; k < a[0].length; ++k)
                {
                    b[k] += a[j][k];
                }

                int cur = MaxSubArraySum(b);
                if (cur > sum)
                    sum = cur;
            }
        }

        return sum;
    }

    public static int MaxNonAdjacentSubArraySum(int[] a)
    {
        if (1 == a.length)
            return a[0];

        int len = a.length;
        int[] m = new int[len];
        int[] n = new int[len];

        m[0] = 0;
        n[0] = a[0];

        for (int i = 1; i < len; ++i)
        {
            m[i] = Math.max(m[i-1],n[i-1]);
            n[i] = m[i-1]+a[i];
        }

        return Math.max(m[len-1],n[len-1]);
    }

    public static void main(String[] args)
    {
        int[] a= {1,7,4,0,9,4,8,8};

        System.out.print(MaxNonAdjacentSubArraySum(a));
    }
}
