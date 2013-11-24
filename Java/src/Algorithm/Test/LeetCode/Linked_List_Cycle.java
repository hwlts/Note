package Algorithm.Test.LeetCode;

/**
 * Given a linked list, determine if it has a cycle in it.
 */
public class Linked_List_Cycle
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

    public boolean hasCycle(ListNode head)
    {
        if (head == null)
            return false;

        ListNode p = head;
        ListNode q = head;

        while (p != null)
        {
            p = p.next;
            if (p == null)
                return false;
            p = p.next;
            q = q.next;
            if (p == q)
                return true;
        }

        return false;
    }
}
