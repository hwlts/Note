package ACM.LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreeInorderTraversal
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

    public ArrayList<Integer> inorderTraversal(TreeNode root)
    {
        if (root == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> r = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null)
        {
            if (root.left != null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                r.add(root.val);
                if (root.right != null)
                    root = root.right;
                else
                {
                    while (!stack.empty())
                    {
                        if (stack.peek().right == null)
                        {
                            r.add(stack.peek().val);
                            stack.pop();
                        }
                        else
                            break;
                    }

                    if (stack.empty())
                        root = null;
                    else
                    {
                        r.add(stack.peek().val);
                        root = stack.peek().right;
                        stack.pop();
                    }
                }
            }
        }

        return r;
    }
}
