package WeakPoint;

public class DeadLock
{
    public static void main(String[] args)
    {
        A a = new A();
        B b = new B(a);
        a.setB(b);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t2.start();
        t1.start();
    }
}

class A implements Runnable
{
    private B b;

    public void setB(B b)
    {
        this.b = b;
    }

    public void run()
    {
        while (true)
        {
            synchronized (this)
            {
                b.write();
            }
        }
    }

    public synchronized void write()
    {
        System.out.println("A is writing." + System.currentTimeMillis());
    }
}

class B implements Runnable
{
    private A a;

    public B(A a)
    {
        this.a = a;
    }

    public void run()
    {
        while (true)
        {
            synchronized (this)
            {
                a.write();
            }
        }
    }

    public synchronized void write()
    {
        System.out.println("B is writing." + System.currentTimeMillis());
    }
}