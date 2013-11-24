package Algorithm.Test.LeetCode;

/**
 * A linked list is given such that
 * each node contains an additional random pointer
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 */

public class Copy_List_With_Random_Pointer
{
    public static class RandomListNode
    {
        int label;
        RandomListNode next, random;

        RandomListNode(int x)
        {
            this.label = x;
        }
    };

    /**
     * 根据源链表依次复制出新链表的对应节点，并将新节点插入到源节点后，
     * 新链表的rand指针指向原链表的rand；
     * 然后遍历一遍链表，
     * 将新链表的rand指针指向对应元素的next元素（即新链表中对应的rand指针元素）；
     * 最后将新链表和源链表分离。
     */

    public RandomListNode copyRandomList(RandomListNode head)
    {
        if (head == null)
            return head;

        RandomListNode p = head;
        while (p != null)
        {
            RandomListNode n = new RandomListNode(p.label);
            RandomListNode t = p;
            p = p.next;
            t.next = n;
            n.random = t.random;
            n.next = p;
        }

        p = head;
        while (p != null)
        {
            p = p.next;
            if (p.random != null)
                p.random = p.random.next;
            else
                p.random = null;
            p = p.next;
        }

        RandomListNode r = head.next;
        p = head;
        while (p != null)
        {
            RandomListNode t = p.next.next;
            if (t == null)
                p.next.next = null;
            else
                p.next.next = t.next;
            p.next = t;
            p = t;
        }

        return r;
    }
}
