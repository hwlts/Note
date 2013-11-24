package WeakPoint;

/**
    Thread.join()方法的作用
 */
public class JoinThread extends Thread
{
    public static int n = 0;

    static synchronized void inc()
    {
        n++;
    }

    public void run()
    {
        for (int i = 0; i < 10; ++i)
            try
            {
                inc();
                sleep(3);       //为了使运行结果更随机，延迟3毫秒

            }
            catch (Exception e)
            {
            }
    }

    public static void main(String[] args) throws Exception
    {

        Thread threads[] = new Thread[100];
        for (int i = 0; i < threads.length; i++)    // 建立100个线程
            threads[i] = new JoinThread();
        for (int i = 0; i < threads.length; i++)    // 运行刚才建立的100个线程
        {
            threads[i].start();
            threads[i].join();                      //
        }
        System.out.println("n=" + JoinThread.n);
    }
}
