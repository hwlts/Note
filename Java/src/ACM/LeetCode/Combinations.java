package ACM.LeetCode;

import java.util.ArrayList;

/**
 * Given two integers n and k,
 * return all possible combinations of k numbers out of 1 ... n.
 * For example, If n = 4 and k = 2, a solution is:
 * [
 *      [2,4],
 *      [3,4],
 *      [2,3],
 *      [1,2],
 *      [1,3],
 *      [1,4],
 * ]
 */

public class Combinations
{
    public static ArrayList<ArrayList<Integer>> combine(int n, int k)
    {
        return combine_Helper(1,n,k);
    }

    public static ArrayList<ArrayList<Integer>> combine_Helper(int b, int e, int k)
    {
        ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
        if (k == 1)
        {
            for (int i = b; i <= e; ++i)
            {
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                l.add(a);
            }

            return l;
        }
        else
        {
            for (int i = b; i <= e-k+1; ++i)
            {
                ArrayList<ArrayList<Integer>> t = combine_Helper(i+1,e,k-1);
                for (ArrayList<Integer> a : t)
                {
                    a.add(0,i);
                }
                l.addAll(t);
            }

            return l;
        }
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> l = combine(4,2);
        System.out.print("");
    }
}
