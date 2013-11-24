package ACM.LeetCode;

/**
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 * Note: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */

public class SingleNumber
{
    public int singleNumber(int[] A)
    {
        if (1 == A.length)
            return A[0];
        int r = A[0];
        for (int i = 1; i < A.length; ++i)
        {
            r ^= A[i];
        }

        return r;
    }
}
