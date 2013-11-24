package ACM.LeetCode;

/**
 * Given a binary tree,
 * determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * 1.The left subtree of a node contains only nodes
 * with keys less than the node's key.
 *
 * 2.The right subtree of a node contains only nodes
 * with keys greater than the node's key.
 *
 * 3.Both the left and right subtrees must also be binary search trees.
 */

public class ValidateBinarySearchTree
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

    public boolean isValidBST(TreeNode root)
    {
        if (root == null)
            return true;

        boolean l = true;
        if (root.left != null)
            l = (getMax(root.left) < root.val) && isValidBST(root.left);

        boolean r = true;
        if (root.right != null)
            r = (getMin(root.right) > root.val) && isValidBST(root.right);

        return l && r;
    }

    private int getMax(TreeNode p)
    {
        int max = Integer.MIN_VALUE;
        while (p != null)
        {
            max = (p.val > max) ? p.val : max;
            p = p.right;
        }
        return max;
    }

    private int getMin(TreeNode p)
    {
        int min = Integer.MAX_VALUE;
        while (p != null)
        {
            min = (p.val < min) ? p.val : min;
            p = p.left;
        }
        return min;
    }
}
