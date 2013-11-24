package ACM.CampusRecruit.WorksApplication;

/**
 * 递增子序列
 */

public class LongestIncreaseSubArray
{
    /**
     * 连续
     */

    int f(int[] a )
    {
        if (a.length == 1)
            return 1;

        int max = 1;
        int begin = 0;
        for(int i = 1; i < a.length; ++i)
        {
            if (a[i] > a[i-1])
            {
                int cur = i-begin+1;
                max = (max > cur) ? max : cur;
            }
            else
                begin = i;
        }

        return max;
    }


    /**
     * 不连续
     */

    int g(int[] a)
    {
        if (a.length == 1)
            return 1;

        int[] b = new int[a.length];
        b[0] = 1;
        for (int i = 1; i < a.length; ++i)
        {
            int max = 1;
            for (int j = 0; j < i; ++j)
            {
                int cur;
                if (a[j] < a[i])
                {
                    cur = b[j] + 1;
                    max = (max > cur) ? max : cur;
                }
                b[i] = max;
            }
        }

        for (int i = 1; i < b.length; ++i)
        {
            if (b[i] > b[0])
                b[0] = b[i];
        }
        return b[0];
    }

    public static void main(String[] args)
    {
        int[] a= {2,1,3,5,0};

        System.out.print(new LongestIncreaseSubArray().g(a));
    }
}
