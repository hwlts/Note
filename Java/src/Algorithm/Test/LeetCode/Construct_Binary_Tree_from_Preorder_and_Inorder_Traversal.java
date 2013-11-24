package Algorithm.Test.LeetCode;

/**
 * Given preorder and inorder traversal of a tree,
 * construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal
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

    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if (preorder == null || inorder == null)
            return null;

        return Helper(preorder,0,inorder,0,preorder.length);
    }

    private int getIndex(int[] a, int t)
    {
        for (int i = 0; i < a.length; ++i)
        {
            if (a[i] == t)
                return i;
        }

        return -1;
    }

    private TreeNode Helper(int[] preorder, int pre_begin, int[] inorder, int in_begin, int len)
    {
        if (preorder == null || inorder == null || len < 1)
            return null;

        if (len == 1)
            return new TreeNode(preorder[pre_begin]);

        TreeNode root = new TreeNode(preorder[pre_begin]);

        int rootIndex = getIndex(inorder,preorder[pre_begin]);
        int left_len = rootIndex-in_begin;
        int right_len = len-1-left_len;

        TreeNode left = Helper(preorder, pre_begin+1, inorder, in_begin, left_len);
        TreeNode right = Helper(preorder, pre_begin+left_len+1, inorder, rootIndex+1, right_len);

        root.left = left;
        root.right = right;

        return root;
    }
}
