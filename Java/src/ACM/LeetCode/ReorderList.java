package ACM.LeetCode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

public class ReorderList
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

    public void reorderList(ListNode head)
    {
        if (head == null || head.next == null)
            return;

        ListNode h = GetHalf(head);
        ListNode t = h.next;
        h.next = null;
        ListNode n = ReverseList(t);

        ListNode p = head;
        ListNode q = n;

        while (q != null)
        {
            ListNode temp0 = p.next;
            ListNode temp1 = q.next;
            p.next = q;
            q.next = temp0;
            p = temp0;
            q = temp1;
        }
    }

    private ListNode ReverseList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode p = head;
        ListNode q = head.next;
        while (q != null)
        {
            ListNode t = q.next;
            q.next = p;
            p = q;
            q = t;
        }
        head.next = null;
        return p;
    }

    private ListNode GetHalf(ListNode head)
    {
        int len = 0;
        ListNode p = head;

        while ( p != null)
        {
            len++;
            p = p.next;
        }

        int half = (len%2 == 0) ? (len/2 - 1) : (len/2);

        int i = 0;
        p = head;
        while ( i != half)
        {
            p = p.next;
            i++;
        }

        return p;
    }

    public static void main(String[] args)
    {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next = two;
        two.next = three;

        ListNode l = new ReorderList().ReverseList(one);
        System.out.println();
    }

}
