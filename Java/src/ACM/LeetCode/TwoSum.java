package ACM.LeetCode;

/**
 * Given an array of integers,
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that
 * they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers
 * (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum
{
    public int[] twoSum(int[] numbers, int target)
    {
        if (0 == numbers.length)
            return new int[] {-1,-1};

        Map<Integer,Integer> m = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; ++i)
        {
            m.put(numbers[i],i+1);
        }

        for (int i = 0; i < numbers.length-1; ++i)
        {
            if (m.containsKey(target-numbers[i]))
                return new int[] {i+1,m.get(target-numbers[i])};
        }

        return new int[] {-1,-1};

    }
}
