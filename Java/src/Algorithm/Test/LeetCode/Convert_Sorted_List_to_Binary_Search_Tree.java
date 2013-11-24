package Algorithm.Test.LeetCode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */

public class Convert_Sorted_List_to_Binary_Search_Tree
{
    static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
            next = null;
        }
    }

    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head)
    {
        if (head == null)
            return null;

        return Helper(head, getLength(head));
    }

    private int getLength(ListNode p)
    {
        int count = 0;
        while (p != null)
        {
            ++count;
            p = p.next;
        }

        return count;
    }

    private ListNode KthNode(ListNode p, int k)
    {
        int i = 0;

        while (i != k)
        {
            p = p.next;
            ++i;
        }

        return p;
    }

    private TreeNode Helper(ListNode p, int len)
    {
        if (p == null || len < 1)
            return null;

        if (len == 1)
            return new TreeNode(p.val);

        int mid = len/2;
        ListNode midNode = KthNode(p,mid);
        int left_len = mid ;
        int right_len = len - 1 - left_len;

        TreeNode root = new TreeNode(midNode.val);
        TreeNode left = Helper(p, left_len);
        TreeNode right = Helper(midNode.next, right_len);
        root.left = left;
        root.right = right;

        return root;
    }
}
