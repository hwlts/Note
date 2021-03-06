package ACM.LeetCode;

/**
 * Write an efficient algorithm that
 * searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater
 * than the last integer of the previous row.
 * For example, Consider the following matrix:
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */

public class SearchA2DMatrix
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix == null)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n-1;
        while (i >= 0 && i <= m-1 && j >= 0 && j <= n-1)
        {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                --j;
            else
                ++i;
        }
        return false;
    }
}
