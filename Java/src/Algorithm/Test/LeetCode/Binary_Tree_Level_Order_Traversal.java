package Algorithm.Test.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree,
 * return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *          3
 *         / \
 *        9  20
 *       /  \
 *      15   7
 * return its level order traversal as:
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 *
 */

public class Binary_Tree_Level_Order_Traversal
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

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root)
    {
        if (root == null)
            return new ArrayList<ArrayList<Integer>>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();

        ArrayList<Integer> r = new ArrayList<Integer>();

        nodeQueue.offer(root);
        depthQueue.offer(0);

        int depth = 0;
        while (nodeQueue.size() > 0)
        {
            TreeNode t = nodeQueue.peek();
            int c = depthQueue.peek();

            if (c == depth)
                r.add(t.val);
            else
            {
                res.add(r);
                r = new ArrayList<Integer>();
                r.add(t.val);
                depth = c;
            }

            if (t.left != null)
            {
                nodeQueue.offer(t.left);
                depthQueue.offer(c+1);
            }

            if (t.right != null)
            {
                nodeQueue.offer(t.right);
                depthQueue.offer(c+1);
            }

            nodeQueue.poll();
            depthQueue.poll();
        }

        res.add(r);

        return res;
    }
}
