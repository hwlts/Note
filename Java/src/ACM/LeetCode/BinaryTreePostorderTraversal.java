package ACM.LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
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

public class BinaryTreePostorderTraversal
{
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root)
    {
        if (root == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        boolean inLeft = true;

        while (p != null)
        {
            if (p.left != null)
            {
                stack.push(p);
                p = p.left;
            }
            else if (p.left == null && p.right != null)
            {
                stack.push(p);
                p = p.right;
            }
            else //p->left == NULL && p->right == NULL
            {
                result.add(p.val);
                TreeNode temp=p;
                while (!stack.empty())
                {
                    if (stack.peek().right == null || stack.peek().right == temp)
                    {
                        result.add(stack.peek().val);
                        temp=stack.peek();
                        stack.pop();
                    }
                    else
                    break;
                }
                if (stack.empty())
                    p = null;
                else
                    p = stack.peek().right;
            }
        }

        return result;
    }

}
