package ACM.LeetCode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree?
 * Would your previous solution still work?
 *
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *      1
 *     /  \
 *    2    3
 *   / \    \
 *  4   5    7
 * After calling your function, the tree should look like:
 *      1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \    \
 *  4-> 5 -> 7 -> NULL
 */

public class PopulatingNextRightPointersInEachNode2
{
    public static class TreeLinkNode
    {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x)
        {
            val = x;
        }
    }

    public void connect(TreeLinkNode root)
    {
        if (root == null)
            return;

        TreeLinkNode p = root;
        TreeLinkNode q = null;
        TreeLinkNode nextNode = null;

        while(p != null)
        {
            if (p.left != null)
            {
                if (q != null)
                    q.next = p.left;
                q = p.left;
                if (nextNode == null)
                    nextNode = q;
            }

            if (p.right != null)
            {
                if (q != null)
                    q.next = p.right;
                q = p.right;
                if (nextNode == null)
                    nextNode = q;
            }

            p = p.next;
        }

        connect(nextNode);
    }

    public static void main(String[] args)
    {
        TreeLinkNode a = new TreeLinkNode(0);
        TreeLinkNode b = new TreeLinkNode(1);
        TreeLinkNode c = new TreeLinkNode(2);
        TreeLinkNode d = new TreeLinkNode(3);
        TreeLinkNode e = new TreeLinkNode(4);
        TreeLinkNode f = new TreeLinkNode(5);
        TreeLinkNode g = new TreeLinkNode(6);
        TreeLinkNode h = new TreeLinkNode(7);
        TreeLinkNode i = new TreeLinkNode(8);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        d.left = h;

        g.right = i;

        new PopulatingNextRightPointersInEachNode2().connect(a);

        System.out.println("Hello");
    }
}
