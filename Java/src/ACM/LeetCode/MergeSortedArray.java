package ACM.LeetCode;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 */

public class MergeSortedArray
{
    public void merge(int A[], int m, int B[], int n)
    {
        if (null == A || null == B || 0 == n)
            return;

        int p = m-1, q = n-1;
        for (int i = m+n-1; i >= 0; --i)
        {
            if (p>=0 && q>=0)
            {
                if (A[p] > B[q])
                {
                    A[i] = A[p];
                    --p;
                }
                else
                {
                    A[i] = B[q];
                    --q;
                }
            }

            else if (p<0 && q>=0)
            {
                A[i] = B[q];
                --q;
            }

            else if (p >=0 && q<0)
            {
                A[i] = A[p];
                --p;
            }
        }

        return;
    }
}
