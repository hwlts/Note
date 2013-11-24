package ACM.LeetCode;

/**
 * Given an array and a value,
 * remove all instances of that value in place and return the new length.
 * The order of elements can be changed.
 * It doesn't matter what you leave beyond the new length.
 */

public class RemoveElement
{
    public int removeElement(int[] A, int elem)
    {
        int d = 0;
        for (int i = 0; i < A.length; ++i)
        {
            if (A[i] == elem)
            {
                d++;
            }
            else
            {
                A[i-d] = A[i];
            }
        }

        return A.length - d;
    }
}
