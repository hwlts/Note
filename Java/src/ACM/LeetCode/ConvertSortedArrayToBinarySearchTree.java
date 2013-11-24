package ACM.LeetCode;

/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */

public class ConvertSortedArrayToBinarySearchTree
{
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] num)
    {
        if (num == null || num.length < 1)
            return null;

        return Helper(num,0,num.length);
    }

    private TreeNode Helper(int[] num, int begin, int len)
    {
        if (num == null || len < 1)
            return null;

        if (len == 1)
            return new TreeNode(num[begin]);

        int mid = len/2 + begin;
        int left_len = mid - begin;
        int right_len = len - 1 - left_len;

        TreeNode root = new TreeNode(num[mid]);
        TreeNode left = Helper(num,begin,left_len);
        TreeNode right = Helper(num,mid+1,right_len);

        root.left = left;
        root.right = right;

        return root;
    }
}
