package ACM.CampusRecruit.MSCampusRecruit2014;

/**
 * Created with IntelliJ IDEA.
 * User: Malone
 * Date: 13-10-7
 * Time: 上午1:11
 * To change this template use File | Settings | File Templates.
 */

public class ReorderList
{
    public static class Node
    {
        int val;
        Node next;

        Node(int i)
        {
            val = i;
        }
    }

    public static Node reOrder(Node head)
    {
        Node p = head;

        int len = 0;
        while (p != null)
        {
            ++len;
            p = p.next;
        }

        int i = 1;
        p = head;
        while (i < (len/2+1))
        {
            p = p.next;
            ++i;
        }
        Node left_end = p;
        Node right_begin = p.next;

        p.next = null;
        Node r = revsereList(right_begin);

        Node m = head;
        Node n = r;
        while ( n != null)
        {
            Node m_next = m.next;
            Node n_next = n.next;
            m.next = n;
            n.next = m_next;
            m = m_next;
            n = n_next;
        }

        return head;
    }

    public static Node revsereList(Node head)
    {
        if (null == head || null == head.next)
            return head;

        Node e = head.next;
        Node r = revsereList(e);
        e.next = head;
        head.next = null;
        return r;
    }

    public static void printList(Node head)
    {
        while(head.next != null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.print(head.val);
    }

    public static void main(String[] args)
    {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node n = reOrder(n0);
        printList(n);
    }
}

