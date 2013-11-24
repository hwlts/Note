/*最长不重复子串*/

package Algorithm.Test;

import java.util.HashMap;
import java.util.Map;

public class LNRS
{
    static String LongestNonRepeatedSubString(String str)
    {
        Map<Character, Integer> m = new HashMap<Character, Integer>();

        int i = 0;
        int begin = 0;      //全局begin
        int end = 0;        //全局end
        int len = 0;        //全局子串长度
        int tempBegin = 0;
        int tempLen = 0;
        for (; i < str.length(); ++i)
        {
            if (!m.containsKey(str.charAt(i)))
            {
                m.put(str.charAt(i), i);
                int temp = i - tempBegin + 1;
                if (temp > len)
                {
                    end = i;
                    begin = tempBegin;
                    len = temp;
                }
            }
            else
            {
                int p = m.get(str.charAt(i));
                if (p < tempBegin)
                {
                    m.put(str.charAt(i), i);
                    int temp = i - tempBegin + 1;
                    if (temp > len)
                    {
                        end = i;
                        begin = tempBegin;
                        len = temp;
                    }
                }
                else
                {
                    tempBegin = p + 1;
                    m.put(str.charAt(i), i);
                }
            }
        }
        return str.substring(begin, end + 1);
    }

    public static void main(String[] args)
    {
        String s = "abccdefabc";
        System.out.println(LongestNonRepeatedSubString(s));
    }
}
