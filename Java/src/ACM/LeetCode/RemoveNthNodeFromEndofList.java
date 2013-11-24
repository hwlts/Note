package ACM.LeetCode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example, Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note: Given n will always be valid.
 * Try to do this in one pass.
 */

public class RemoveNthNodeFromEndofList
{
    public class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode p = head, q = null;

        int i = 0;
        while(p != null)
        {
            p = p.next;
            if (i < n)
                ++i;
            else if (null == q)
                q = head;
            else
                q = q.next;
        }

        if (null == q)
        {
            return head.next;
        }
        else if (q.next.next == null)
        {
            q.next = null;
            return head;
        }
        else
        {
            q.next = q.next.next;
            return head;
        }
    }
}
