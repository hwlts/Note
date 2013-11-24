package Algorithm.Test.LeetCode;

/**
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 * For example, "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */

public class Valid_Palindrome
{
    public boolean isPalindrome(String s)
    {
        int b = 0, e = s.length()-1;
        while(b <= e)
        {
            char x = s.charAt(b);
            char y = s.charAt(e);
            if (isCharacter(x) && isCharacter(y) && !isSame(x,y))
                return false;
            else if (isCharacter(x) && isCharacter(y) && isSame(x,y))
            {
                ++b;
                --e;
            }
            else
            {
                if (!isCharacter(x))
                    ++b;
                if (!isCharacter(y))
                    --e;
            }
        }

        return true;
    }

    public boolean isCharacter(char c)
    {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c<='9');
    }

    public boolean isSame(char x, char y)
    {
        return x == y || (Math.abs(x-y) == Math.abs('A'-'a'));
    }
}
