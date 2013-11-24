package ACM.CampusRecruit.HuaWeiTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test201201
{
    static int isMatch(String s)
    {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i)
        {
            if (s.charAt(i) == '(' || s.charAt(i) == '[')
            {
                st.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')')
            {
                if (st.peek() == '(')
                {
                    st.pop();
                }
                else
                    return 1;
            }
            else if (s.charAt(i) == ']')
            {
                if (st.peek() == '[')
                {
                    st.pop();
                }
                else
                    return 1;
            }
        }

        if (!st.empty())
        {
            return 1;
        }

        return 0;
    }
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String s = reader.readLine();
            System.out.println(isMatch(s));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
