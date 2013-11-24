package ACM.LeetCode;

/**
 * Given inorder and postorder traversal of a tree,
 * construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal
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

    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        if (inorder == null || postorder == null)
            return null;

        if (inorder.length == 1)
            return new TreeNode(inorder[0]);

        return Helper(inorder,0,postorder,0,inorder.length);
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

    private TreeNode Helper(int[] inorder, int in_begin, int[] postorder, int post_begin, int len)
    {
        if (inorder == null || postorder == null || len < 1)
            return null;

        if (len == 1)
            return new TreeNode(inorder[in_begin]);

        TreeNode root = new TreeNode(postorder[post_begin+len-1]);

        int rootIndex = getIndex(inorder,postorder[post_begin+len-1]);
        int left_len = rootIndex-in_begin;
        int right_len = len-1-left_len;

        TreeNode left = Helper(inorder, in_begin, postorder, post_begin, left_len);
        TreeNode right = Helper(inorder, rootIndex+1, postorder, post_begin+left_len, right_len);

        root.left = left;
        root.right = right;
        return root;
    }
}
