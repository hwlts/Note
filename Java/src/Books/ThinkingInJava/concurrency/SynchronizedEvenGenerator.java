package Books.ThinkingInJava.concurrency;

public class SynchronizedEvenGenerator extends IntGenerator
{
    private int currentValue = 0;

    public synchronized int next()
    {
        ++currentValue;
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args)
    {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
