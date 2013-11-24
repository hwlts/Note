package ACM.LeetCode;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes
 * along the longest path from the root node down to the farthest leaf node.
 */

public class MaximumDepthOfBinaryTree
{
    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root)
    {
        if (null == root)
            return 0;

        if (null == root.left && null == root.right)
            return 1;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return (l > r) ? l+1 : r+1;
    }
}
