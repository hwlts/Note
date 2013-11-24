package ACM.LeetCode;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class RemoveDuplicatesFromSortedArray2
{
    public int removeDuplicates(int[] A)
    {
        if (1 == A.length)
            return 1;

        int cur = 1, total = 0;

        for (int i = 1; i < A.length; ++i)
        {
            if (A[i] != A[i-1])
            {
                cur = 1;
                A[i-total] = A[i];
            }
            else
            {
                ++cur;
                if (cur > 2)
                    ++total;
                else
                {
                    A[i-total] = A[i];
                }
            }
        }

        return A.length - total;
    }
}
