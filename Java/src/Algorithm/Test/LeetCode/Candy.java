package Algorithm.Test.LeetCode;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */

public class Candy
{
    public int candy(int[] ratings)
    {
        if (ratings == null)
            return 0;

        int len = ratings.length;
        int[] c = new int[len];
        Arrays.fill(c,1);

        for (int i = 0; i < len-1; ++i)
        {
            if (ratings[i] < ratings[i+1])
                c[i+1] = c[i]+1;
        }

        for (int i = len-1; i > 0; --i)
        {
            if (ratings[i] < ratings[i-1] && c[i-1] <= c[i])
                c[i-1] = c[i]+1;
        }

        int sum = 0;
        for (int i = 0; i < len; ++i)
            sum += c[i];

        return sum;
    }
}
