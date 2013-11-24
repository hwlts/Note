package ACM.LeetCode;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order
 * and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if (l1 == null || l2 == null)
            return null;

        int d = 0;
        int n = l1.val+l2.val;
        if (n >= 10)
        {
            n %= 10;
            d = 1;
        }

        ListNode head = new ListNode(n);
        ListNode p = head;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null)
        {
            n = l1.val + l2.val + d;
            if (n >= 10)
            {
                n %= 10;
                d = 1;
            }
            else
                d = 0;
            ListNode t = new ListNode(n);
            p.next = t;
            p = t;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l = (l1 == null) ? l2 : l1;
        while (l != null)
        {
            n = l.val + d;
            if (n >= 10)
            {
                n %= 10;
                d = 1;
            }
            else
                d = 0;
            ListNode t = new ListNode(n);
            p.next = t;
            p = t;
            l = l.next;
        }

        if (0 != d)
            p.next = new ListNode(d);

        return head;
    }
}
