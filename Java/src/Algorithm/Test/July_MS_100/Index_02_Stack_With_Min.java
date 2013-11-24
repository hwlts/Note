package Algorithm.Test.July_MS_100;

/**
 *********************************************************
 2. 设计包含Min函数的栈
 题目：
 定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。
 要求函数min、push以及pop的时间复杂度都是O(1)。
 **********************************************************
 Stack is a LIFO data structure. When some element is popped from the stack,
 the status will recover to the original status as before that element was pushed.
 So we can recover the minimum element, too.
 **********************************************************
 */


public class Index_02_Stack_With_Min
{
    static class MinStackElement
    {
        int data;
        int min;

        MinStackElement(int d)
        {
            data = d;
        }
    }

    static class MinStack
    {
        MinStackElement[] data;
        int size;
        int top;

        MinStack(int maxSize)
        {
            data = new MinStackElement[maxSize];
            size = maxSize;
            top = 0;
        }

        void Push(int d) throws Exception
        {
            if (top == size)
                throw new Exception("Out of stack space");

            int p = data[top].min;

            ++top;
            data[top] = new MinStackElement(d);
            data[top].min = (top == 0) ? d : p;
        }
    }


}
