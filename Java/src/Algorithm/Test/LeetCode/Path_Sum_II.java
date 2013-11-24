package Algorithm.Test.LeetCode;

import java.util.ArrayList;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *              5
 *             / \
 *            4   8
 *           /   / \
 *          11  13  4
 *         /  \    / \
 *        7    2  5   1
 * return
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
 */

public class Path_Sum_II
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

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum)
    {
        if (root == null)
            return new ArrayList<ArrayList<Integer>>();

        ArrayList<ArrayList<Integer>> pathes = new ArrayList<ArrayList<Integer>>();

        if (root.left == null && root.right == null)
        {
            if (root.val == sum)
            {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(root.val);
                pathes.add(l);
                return pathes;
            }
            else
                return new ArrayList<ArrayList<Integer>>();
        }

        if (root.left != null)
        {
            ArrayList<ArrayList<Integer>> r = pathSum(root.left,sum-root.val);
            if (r.size() > 0)
            {
                for (ArrayList<Integer> a : r)
                {
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(root.val);
                    l.addAll(a);
                    pathes.add(l);
                }
            }
        }

        if (root.right != null)
        {
            ArrayList<ArrayList<Integer>> r = pathSum(root.right,sum-root.val);
            if (r.size() > 0)
            {
                for (ArrayList<Integer> a : r)
                {
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(root.val);
                    l.addAll(a);
                    pathes.add(l);
                }
            }
        }

        return pathes;
    }

    public static void main(String[] args)
    {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        one.left = two;

        ArrayList<ArrayList<Integer>> r = new Path_Sum_II().pathSum(one,0);
        System.out.println();
    }
}
