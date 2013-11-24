package Algorithm.Test.LeetCode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example: Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */

public class Rotate_List
{
    public static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
            next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int n)
    {
        if (null == head || null == head.next)
            return head;

        ListNode p = head;
        int len = 0;

        while (p != null)
        {
            len++;
            p = p.next;
        }

        n %= len;

        if (n == 0)
            return head;

        ListNode r = null, end = head;
        int i = 0;
        p = head;
        while (p != null)
        {
            if (null == p.next)
                end = p;

            if (i < n)
            {
                p = p.next;
                ++i;
            }
            else if (i == n)
            {
                r = head;
                p = p.next;
                ++i;
            }
            else
            {
                r = r.next;
                p = p.next;
                ++i;
            }
        }

        ListNode h = r.next;
        end.next = head;
        r.next = null;

        return h;
    }
}
