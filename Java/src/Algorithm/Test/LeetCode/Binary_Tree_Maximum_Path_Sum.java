package Algorithm.Test.LeetCode;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 *
 * For example:
 * Given the below binary tree,
 *   1
 *  / \
 * 2   3
 * Return 6.
 *
 */

public class Binary_Tree_Maximum_Path_Sum
{
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static class ReturnValue
    {
        int within = Integer.MIN_VALUE;
        int all = Integer.MIN_VALUE;

        public ReturnValue(int within, int all)
        {
            this.within = within;
            this.all = all;
        }
    }

    private ReturnValue Helper(TreeNode p)
    {
        if (p == null)
            return new ReturnValue(Integer.MIN_VALUE,Integer.MIN_VALUE);

        if (p.left == null && p.right == null)
            return new ReturnValue(p.val,p.val);

        ReturnValue l = Helper(p.left);
        ReturnValue r = Helper(p.right);

        int within = Math.max(Math.max(l.within,r.within) + p.val,p.val);

        int temp0 = Math.max(l.all,r.all);
        int temp1 = p.val;

        if (l.within > 0 && r.within > 0)
            temp1 = p.val + l.within + r.within;
        else if (l.within <= 0 && r.within > 0)
            temp1 = p.val + r.within;
        else if (r.within <= 0 && l.within > 0)
            temp1 = p.val + l.within;

        int all = Math.max(temp0,temp1);

        return new ReturnValue(within,all);
    }

    public int maxPathSum(TreeNode root)
    {
        ReturnValue r = Helper(root);
        return r.all;
    }

    public static void main(String[] args)
    {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;

        int r = new Binary_Tree_Maximum_Path_Sum().maxPathSum(a);
        System.out.println(r);
    }
}
