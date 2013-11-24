package Algorithm.Test.LeetCode;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */

public class Count_And_Say
{
    public String countAndSay(int n)
    {
        String s = "1";
        if (n == 1)
            return s;

        for (int m = 2; m <= n; ++m)
        {
            int i = 0;
            String t = "";
            while(i < s.length())
            {
                int j = i+1;
                while(j < s.length())
                {
                    if (s.charAt(j) == s.charAt(j-1))
                        ++j;
                    else
                        break;
                }

                t += (j-i)+""+s.charAt(i);
                i = j;
            }
            s = t;
        }

        return s;
    }
}
