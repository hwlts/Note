package ACM.LeetCode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as
 * a binary tree in which the depth of the two subtrees of every node
 * never differ by more than 1.
 */

public class BalancedBinaryTree
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

    public boolean isBalanced(TreeNode root)
    {
        if (root == null)
            return true;

        int l = getDepth(root.left);
        int r = getDepth(root.right);

        if (Math.abs(l-r) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode p)
    {
        if (p == null)
            return 0;

        return Math.max(getDepth(p.left),getDepth(p.right)) + 1;
    }
}
