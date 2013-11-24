package Algorithm.Test.LeetCode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note: Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */

public class Reverse_Linked_List_2
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

    public ListNode reverseN(ListNode node, int N)
    {
        if (null == node || N <= 1)
            return node;

        ListNode e = node.next;
        ListNode t = reverseN(node.next,N-1);
        e.next = node;
        node.next = null;
        return t;
    }

    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (head == null || m == n)
            return head;

        ListNode p = head, begin = null, end = null;
        int index = 1;
        while (p != null)
        {
            if (index < m-1)
            {
                ++index;
                p = p.next;
            }
            else if (index == m-1)
            {
                begin = p;
                ++index;
                p = p.next;
            }
            else if (index < n+1)
            {
                ++index;
                p = p.next;
            }
            else if (index == n+1)
            {
                end = p;
                break;
            }
            else
            {
                ++index;
                p = p.next;
            }
        }

        if (null == begin && null == end)
            return reverseN(head,index-1);
        else if (null == begin && null != end)
        {
            ListNode r = reverseN(head,n-m+1);
            head.next = end;
            return r;
        }
        else if (null != begin && null == end)
        {
            ListNode e = begin.next;
            begin.next = reverseN(e,n-m+1);
            e.next = null;
            return head;
        }
        else
        {
            ListNode e = begin.next;
            begin.next = reverseN(e,n-m+1);
            e.next = end;
            return head;
        }
    }
}
