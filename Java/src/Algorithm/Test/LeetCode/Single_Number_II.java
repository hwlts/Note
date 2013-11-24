package Algorithm.Test.LeetCode;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * Note: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */

public class Single_Number_II
{
    /**
     * once记录了所有出现了模3余1次的bit，twice记录的是余2的。
     * not_threes是当一个bit出现第3次的时候，把它清掉。
     * 如果题目中那个特殊的数出现了1次，最后输出once。
     * 如果是出现2次的话，输出twice。
     */

    public int singleNumber(int[] A)
    {
        if (A.length < 4)
            return A[0];

        int once = 0;
        int twice = 0;
        for (int i = 0; i < A.length; ++i)
        {
            twice |= once & A[i];
            once ^= A[i];
            int not_threes = ~(once&twice);
            once &= not_threes;
            twice &= not_threes;
        }

        return once;
    }
}


