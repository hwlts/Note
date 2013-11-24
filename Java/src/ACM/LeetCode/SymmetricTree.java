package ACM.LeetCode;

/**
 * Given a binary tree,
 * check whether it is a mirror of itself (ie, symmetric around its center).
 */

public class SymmetricTree
{
    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root)
    {
        if (null == root)
            return true;

        return Helper(root.left,root.right);
    }

    public boolean Helper(TreeNode l, TreeNode r)
    {
        if (null == l && null == r)
            return true;
        else if (null == l || null == r)
            return false;

        return (l.val == r.val) && Helper(l.left,r.right) && Helper(l.right,r.left);
    }
}
