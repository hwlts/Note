package Algorithm.Test.LeetCode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */

public class Palindrome_Number
{
    public boolean isPalindrome(int x)
    {
        if (x < 0)
            return false;

        int t = x;

        int len = 0;
        while (t != 0)
        {
            ++len;
            t /= 10;
        }

        t = x;
        int m = (int) Math.pow(10,len-1), n = 1;
        while (n < m)
        {
            if ((t/m)%10 != (t/n)%10)
                return false;
            else
            {
                m /= 10;
                n *= 10;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        System.out.print(new Palindrome_Number().isPalindrome(11));
    }
}
