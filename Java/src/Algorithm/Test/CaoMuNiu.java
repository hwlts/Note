/*
* 更好的方法是找到这个递归规律
* a[i] = a[i-1] + a[i-4];
* */

package Algorithm.Test;

public class CaoMuNiu
{
    public int get(int n)
    {
        int a0 = 1;
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int m = 0;
        int i = 1;
        for (;i<=n;++i)
        {
            m += a3;
            a3 = a2;
            a2 = a1;
            a1 = a0;
            a0 = m;
        }
        return m+a0+a1+a2+a3;
    }

}
