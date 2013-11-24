package WeakPoint;

public class TestThread
{
    public static void main(String[] args)
    {
        //test1
        Thread t1 = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    int i = 0;
                    while (i++ < 100000000)
                    {
                        //nothing
                    }
                    System.out.println("A1");
                }
                catch(Exception e)
                {
                    System.out.println("B1");
                }
            }
        };
        t1.start();
        t1.interrupt();

        //test2
        Thread t2 = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(5000);
                    System.out.println("A2");
                }
                catch (Exception e)
                {
                    System.out.println("B2\t" + e);
                }
            }
        };
        t2.start();
        t2.interrupt();

        //test3
        Thread t3 = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    this.wait(50000);
                    System.out.println("A3");
                }
                catch (Exception e)
                {
                    System.out.println("B3\t" + e);
                }
            }
        };
        t3.start();
        t3.interrupt();

        //test4
        Thread t4 = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    synchronized (this)
                    {
                        this.wait(50000);
                    }
                    System.out.println("A4");
                }
                catch (Exception e)
                {
                    System.out.println("B4\t" + e);
                }
            }
        };
        t4.start();
        t4.interrupt();

        //test4
        try
        {
            t4.start();
            System.out.println("A5");
        }
        catch (Exception e)
        {
            System.out.println("B5\t" + e);
        }
    }
}
