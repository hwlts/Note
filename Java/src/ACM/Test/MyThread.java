package ACM.Test;

/**
 * Created with IntelliJ IDEA.
 * User: hwlts
 * Date: 13-10-16
 * Time: 下午8:34
 * To change this template use File | Settings | File Templates.
 */
public class MyThread extends Thread
{
    static class Parent
    {
        private int i = 0;

        public Parent()
        {
            int i = 2;
        }

        public void Print(Object o)
        {
            System.out.println("P"+i);
        }
    }

    static class Child extends Parent
    {
        private int i = 3;

        public Child()
        {
            int i = 6;
        }

        public void Print(String s)
        {
            System.out.println("CS"+i);
        }

        public void Print(Object o)
        {
            System.out.println("CO"+i);
        }
    }

    public static void main(String[] args)
    {
        Child c1 = new Child();
        Parent p1 = c1;
        c1.Print("hello");
        p1.Print("str");
    }
}
