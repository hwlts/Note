package ACM.LeetCode;

/**
 * Given an unsorted array of integers,
 * find the length of the longest consecutive elements sequence.
 * For example, Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4].
 * Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */

import java.util.*;

public class LongestConsecutiveSequence
{
    public int longestConsecutive(int[] num)
    {
        Set<Integer> s = new HashSet<Integer>();

        for (int i = 0; i <num.length; ++i)
        {
            s.add(num[i]);
        }

        int max_length = 0;

        for (int i = 0; i < num.length; ++i)
        {
            if (s.contains(num[i]))
            {
                int current_length = 1;
                int l = num[i] - 1;
                int r = num[i] + 1;

                while (s.contains(l))
                {
                    ++current_length;
                    s.remove(l);
                    --l;
                }

                while (s.contains(r))
                {
                    ++current_length;
                    s.remove(r);
                    ++r;
                }

                max_length = (max_length > current_length) ? max_length : current_length;
            }
        }

        return max_length;
    }

}
