package Algorithm.Test.LeetCode;

/**
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */

public class Linked_List_Cycle_II
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

    public ListNode detectCycle(ListNode head)
    {
        if(head == null || head.next == null)
            return null;

        ListNode p = head.next.next;
        ListNode q = head.next;

        while(p != null)
        {
            if (p == q)
                break;
            else
            {
                if (p.next == null)
                    return null;
                p = p.next.next;
                q = q.next;
            }
        }

        if (p == null)
            return null;

        ListNode r = head;
        while (q != r)
        {
            r = r.next;
            q = q.next;
        }

        return r;
    }
}
