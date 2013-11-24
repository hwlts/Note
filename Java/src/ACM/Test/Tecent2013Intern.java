package ACM.Test;

/**
 给定一数组a[N]，我们希望构造数组b [N]，其中b[j]=a[0]*a[1]…a[N-1] / a[j]，在构造过程中，不允许使用除法：

 要求O（1）空间复杂度和O（n）的时间复杂度。

 除遍历计数器与a[N] b[N]外，不可使用新的变量（包括栈临时变量、堆空间和全局静态变量等）；
 **/

public class Tecent2013Intern
{
    public static void main(String[] args)
    {
        int[] a = {1,2,3,4,5};
        int[] b = new int[5];

        b[0] = 1;
        for (int i = 1; i < 5; ++i)
        {
            b[i] = b[i-1]*a[i-1];
        }

        b[0] = a[4];
        for (int i = 3; i >= 0; --i)
        {
            a[4] = a[i];
            a[i] = b[0];
            b[0] *= a[4];
        }
        a[4] = 1;
        b[0] = 1;

        for (int i = 0; i < 5; ++i)
        {
            b[i] *= a[i];
            System.out.println(b[i]);
        }
    }
}
