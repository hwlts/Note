package ACM.JulyMS100;

/**
*********************************************************
1. 把二元查找树转变成排序的双向链表
题目：
输入一棵二元查找树，将该转换成个排 序的双向链表。
要求不能创建任何新的结点，只调整指针向。
        10
        / \
       6  14
      / \ / \
      4 8 12 16
 转换成双向链表
 4=6=8=10=12=14=16
**********************************************************
This is a traditional problem that can be solved using recursion.
**********************************************************
 */

public class Index001BSTToSortedList
{
    static class BSTreeNode
    {
        int m_nValue;
        BSTreeNode m_pLeft;
        BSTreeNode m_pRight;

        public BSTreeNode(int n)
        {
            m_nValue = n;
        }
    }

    static class HeadAndTail
    {
        BSTreeNode head;
        BSTreeNode tail;

        HeadAndTail(BSTreeNode h, BSTreeNode t)
        {
            head = h;
            tail = t;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (obj instanceof HeadAndTail)
            {
                return this.head == ((HeadAndTail) obj).head && this.tail == ((HeadAndTail) obj).tail;
            }

            return false;
        }
    }


    /**

     * @param root The root node of the tree.
     * @return The head node of the converted list.
     */
    static BSTreeNode treeToLinkedList(BSTreeNode root)
    {
        return helper(root).head;
    }

    static HeadAndTail helper(BSTreeNode root)
    {
        if (root == null)
            return new HeadAndTail(null,null);
        else
        {
            BSTreeNode head;
            BSTreeNode tail;

            HeadAndTail left_half = helper(root.m_pLeft);
            HeadAndTail right_half = helper(root.m_pRight);

            if (!left_half.equals(new HeadAndTail(null,null)))
            {
                root.m_pLeft = left_half.tail;
                left_half.tail.m_pRight = root;
                head = left_half.head;
            }
            else
                head = root;

            if (!right_half.equals(new HeadAndTail(null,null)))
            {
                root.m_pRight = right_half.head;
                right_half.head.m_pLeft = root;
                tail = right_half.tail;
            }
            else
                tail = root;

            return new HeadAndTail(head,tail);
        }
    }

    public static void main(String[] args)
    {
        BSTreeNode ten = new BSTreeNode(10);
        BSTreeNode six = new BSTreeNode(6);
        BSTreeNode fourteen = new BSTreeNode(14);
        BSTreeNode four = new BSTreeNode(4);
        BSTreeNode eight = new BSTreeNode(8);
        BSTreeNode twelve = new BSTreeNode(12);
        BSTreeNode sixteen = new BSTreeNode(16);

        ten.m_pLeft = six;
        ten.m_pRight = fourteen;

        six.m_pLeft = four;
        six.m_pRight = eight;

        fourteen.m_pLeft = twelve;
        fourteen.m_pRight = sixteen;

        BSTreeNode head = treeToLinkedList(ten);

        System.out.println("From left to right:");
        BSTreeNode t = head;
        while(t.m_pRight != null)
        {
            System.out.print(t.m_nValue+" ");
            t = t.m_pRight;
        }
        System.out.println(t.m_nValue);

        System.out.println("From Right to left:");
        while(t.m_pLeft != null)
        {
            System.out.print(t.m_nValue+" ");
            t = t.m_pLeft;
        }
        System.out.println(t.m_nValue);
    }
}
