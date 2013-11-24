package Algorithm.Test.LeetCode;

/**
 * Given a binary tree,
 * flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 * Hints:
 * If you notice carefully in the flattened tree,
 * each node's right child points to the next node of a pre-order traversal.
 */

public class Flatten_Binary_Tree_to_Linked_List
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

    public void flatten(TreeNode root)
    {
        if (root == null)
            return;

        if(root.left != null)
        {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            root.right = left;
            TreeNode rightMost = root.right;
            while(rightMost.right != null)
            {
                rightMost = rightMost.right;
            }
            rightMost.right = right;
        }

        flatten(root.right);
    }
}
