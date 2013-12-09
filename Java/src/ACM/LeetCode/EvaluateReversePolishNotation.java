package ACM.LeetCode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class EvaluateReversePolishNotation
{
    public int evalRPN(String[] tokens)
    {
        if (tokens == null)
            return 0;
        Stack<String> s = new Stack<String>();
        for(int i = 0; i < tokens.length; ++i)
        {
            if (isNumber(tokens[i]))
                s.push(tokens[i]);
            else
            {
                String b = s.peek();
                s.pop();
                String a = s.peek();
                s.pop();
                int r = compute(a,b,tokens[i]);
                s.push(String.valueOf(r));
            }
        }
        return new Integer(s.peek());
    }

    public static String plus = "+";
    public static String minus = "-";
    public static String multiply = "*";
    public static String divide = "/";

    public static boolean isNumber(String s)
    {
        if (s.equals(plus) || s.equals(minus) || s.equals(multiply) || s.equals(divide))
            return false;
        else
            return true;
    }

    public static int compute(String a, String b, String c)
    {
        int ia = new Integer(a);
        int ib = new Integer(b);
        if (c.equals(plus))
            return ia+ib;
        else if (c.equals(minus))
            return ia-ib;
        else if (c.equals(multiply))
            return ia*ib;
        else
            return ia/ib;
    }
}
