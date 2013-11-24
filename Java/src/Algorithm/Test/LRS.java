/*最长重复子串*/

package Algorithm.Test;

import java.util.*;

public class LRS
{
    static String S;

    static int equalLen(String a, String b)
    {
        int i = 0;
        for (; i < a.length() && i < b.length(); ++i)
        {
            if (a.charAt(i) == b.charAt(i))
                continue;
            else
                break;
        }
        return i;
    }

    static class PostArr implements Comparable<PostArr>
    {
        String sub;

        public PostArr(int i)
        {
            sub = S.substring(i,S.length());
        }

        @Override
        public int compareTo(PostArr o)
        {
            if (this == o)
                return 0;
            else if (o != null )
            {
                return this.sub.compareTo(o.sub);
            }
            else
                return -1;
        }
    }

    static String LongestRepeatedSubString(String str)
    {
        S = str;

        List<PostArr> arr = new ArrayList<PostArr>();
        for (int i = 0; i < str.length(); ++i)
        {
            arr.add(i, new PostArr(i));
        }

        Comparator<PostArr> comparator = new Comparator<PostArr>()
        {
            @Override
            public int compare(PostArr o1, PostArr o2)
            {
                return o1.compareTo(o2);
            }
        };

        Collections.sort(arr,comparator);

        String r = "";

        for (int i = 0; i < arr.size()-1; ++i)
        {
            int t = equalLen(arr.get(i).sub,arr.get(i+1).sub);
            if (t > 0)
            {
                r = (t > r.length()) ? arr.get(i).sub.substring(0,t) : r;
            }
        }

        return r;
    }

    public static void main(String[] args)
    {
        System.out.println(LongestRepeatedSubString("ababa"));
    }
}
