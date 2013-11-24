package ACM.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree,
 * return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *          3
 *         / \
 *        9  20
 *       /  \
 *      15   7
 * return its bottom-up level order traversal as:
 * [
 *  [15,7]
 *  [9,20],
 *  [3],
 * ]
 *
 */

public class BinaryTreeLevelOrderTraversal2
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

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root)
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

        Collections.reverse(res);

        return res;
    }
}
