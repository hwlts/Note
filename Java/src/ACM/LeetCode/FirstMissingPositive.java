package ACM.LeetCode;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */


public class FirstMissingPositive
{
    public int firstMissingPositive(int[] A)
    {
        int n = A.length;
        for (int i = 0; i < n; ++i)
        {
            if (A[i] <= 0)
                A[i] = n+1;
        }

        for (int i = 0; i < n; ++i)
        {
            int t = Math.abs(A[i]);
            if (t <= n)
            {
                if (A[t-1] > 0)
                    A[t-1] *= -1;
            }
        }

        for (int i = 0; i < n; ++i)
        {
            if (A[i] > 0)
                return i + 1;
        }

        return n + 1;
    }
}
