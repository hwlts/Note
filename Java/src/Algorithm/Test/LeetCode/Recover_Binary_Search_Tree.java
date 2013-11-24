package Algorithm.Test.LeetCode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 */

public class Recover_Binary_Search_Tree
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

    static class Helper
    {
        TreeNode p;
        TreeNode q;
        TreeNode pre;

        public Helper(TreeNode p, TreeNode q, TreeNode pre)
        {
            this.p = p;
            this.q = q;
            this.pre = pre;
        }
    }

    public void recoverTree(TreeNode root)
    {
        if (root == null)
            return;

        Helper r = new Helper(null,null,null);
        InOrderTraversal(root,r);

        int temp = r.p.val;
        r.p.val = r.q.val;
        r.q.val = temp;

        return;
    }

    private void InOrderTraversal(TreeNode root,Helper h)
    {
        if (root == null)
            return;

        InOrderTraversal(root.left,h);

        if (h.pre != null && h.pre.val > root.val)
        {
            if (h.p == null)
                h.p = h.pre;

            h.q = root;
        }

        h.pre = root;

        InOrderTraversal(root.right,h);
    }
}
