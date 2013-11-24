package ACM.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *  [1],
 *  [1,1],
 *  [1,2,1],
 *  [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class PascalsTriangle
{
    public ArrayList<ArrayList<Integer>> generate(int numRows)
    {
        ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();

        if (numRows == 0)
            return l;

        ArrayList<Integer> t = new ArrayList<Integer>();
        t.add(1);
        l.add(t);

        if (--numRows == 0)
            return l;

        t = new ArrayList<Integer>();
        t.add(1);
        t.add(1);
        l.add(t);

        if (--numRows == 0)
            return l;

        while (numRows-- != 0)
        {
            t = new ArrayList<Integer>();
            List<Integer> r = l.get(l.size()-1);
            t.add(1);
            for (int i = 1; i < r.size(); ++i)
                t.add(r.get(i-1)+r.get(i));
            t.add(1);
            l.add(t);
        }
        return l;
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> l = new PascalsTriangle().generate(3);
    }
}
