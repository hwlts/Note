package Algorithm.Test.LeetCode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by
 * splicing together the nodes of the first two lists.
 */


public class Merge_Two_Sorted_Lists
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

    public ListNode mergeTwpLists(ListNode l1, ListNode l2)
    {
        ListNode head = null;
        ListNode n = null;

        if (l1 == null)
        {
            head = l2;
            return head;
        }
        if (l2 == null)
        {
            head = l1;
            return head;
        }

        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                if (head == null)
                {
                    head = l1;
                    n = head;
                }
                else
                {
                    n.next = l1;
                    n = n.next;
                }

                l1 = l1.next;
            }
            else
            {
                if (head == null)
                {
                    head = l2;
                    n = head;
                }
                else
                {
                    n.next = l2;
                    n = n.next;
                }

                l2 = l2.next;
            }
        }

        if (l1 != null)
            n.next = l1;

        if (l2 != null)
            n.next = l2;

        return head;
    }
}
