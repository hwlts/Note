package ACM.LeetCode;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */

public class PascalsTriangle2
{
    public ArrayList<Integer> getRow(int rowIndex)
    {
        ArrayList<Integer> l = new ArrayList<Integer>();
        ArrayList<Integer> temp;

        l.add(1);
        if (rowIndex-- == 0)
            return l;

        l.add(1);
        if (rowIndex-- == 0)
            return l;

        while (rowIndex-- != -1)
        {
            temp = l;
            l = new ArrayList<Integer>();
            l.add(1);

            for (int i = 1; i < temp.size(); ++i)
            {
                l.add(temp.get(i-1)+temp.get(i));
            }

            l.add(1);
        }

        return l;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> list= new PascalsTriangle2().getRow(5);
        System.out.println(list);
    }
}
