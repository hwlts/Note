package Algorithm.Test.LeetCode;

/**
 * Given two binary strings, return their sum (also a binary string).
 * For example, a = "11" b = "1" Return "100".
 */

public class Add_Binary
{
    public String addBinary(String a, String b)
    {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        String r = "";

        int i = 0;
        char d = '0';
        while (i < a.length() && i < b.length())
        {
            String t;
            int c = 0;

            if (a.charAt(i) == '1')
                ++c;
            if (b.charAt(i) == '1')
                ++c;
            if (d == '1')
                ++c;

            if (c == 0)
            {
                t = "0";
                d = '0';
            }
            else if (c == 1)
            {
                t = "1";
                d = '0';
            }
            else if (c == 2)
            {
                t = "0";
                d = '1';
            }
            else
            {
                t = "1";
                d = '1';
            }

            r += t;

            ++i;
        }

        String l = (a.length() > b.length()) ? a : b;
        while (i < l.length())
        {
            String t;
            int c = 0;

            if (l.charAt(i) == '1')
                ++c;
            if (d == '1')
                ++c;

            if (c == 0)
            {
                t = "0";
                d = '0';
            }
            else if (c == 1)
            {
                t = "1";
                d = '0';
            }
            else
            {
                t = "0";
                d = '1';
            }

            r += t;

            ++i;
        }

        if (d == '1')
            r += "1";

        return new StringBuilder(r).reverse().toString();
    }
}
