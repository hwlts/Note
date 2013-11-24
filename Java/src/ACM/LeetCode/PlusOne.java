package ACM.LeetCode;

/**
 * Given a number represented as an array of digits,
 * plus one to the number.
 */

public class PlusOne
{
    public int[] plusOne(int[] digits)
    {
        int i = digits.length-1;
        while (i >= 0)
        {
            if (digits[i] != 9)
            {
                digits[i]++;
                return digits;
            }
            else
            {
                digits[i] = 0;
            }
            --i;
        }

        int[] r = new int[digits.length+1];
        r[0] = 1;
        i = 1;
        while (i < r.length)
        {
            r[i] = 0;
            ++i;
        }
        return r;
    }
}
