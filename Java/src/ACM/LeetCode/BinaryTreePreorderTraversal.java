package ACM.LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreePreorderTraversal
{
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root)
    {
        if (root == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while (p != null || !stack.empty())
        {
            if (p != null)
            {
                result.add(p.val);
                if (p.right != null)
                    stack.push(p.right);
                p = p.left;
            }
            else
            {
                p = stack.peek();
                stack.pop();
            }
        }

        return result;
    }
}
