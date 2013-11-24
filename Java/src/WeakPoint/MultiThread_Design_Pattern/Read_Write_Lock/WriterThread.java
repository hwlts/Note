package WeakPoint.MultiThread_Design_Pattern.Read_Write_Lock;

import java.util.Random;

public class WriterThread extends Thread
{
    private static final Random random = new Random();
    private final Data data;
    private final String filler;
    private int index = 0;

    public WriterThread(Data data, String filler)
    {
        this.data = data;
        this.filler = filler;
    }

    public void run()
    {
        try
        {
            while (true)
            {
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(1000));
            }
        }
        catch (InterruptedException e) {}
    }

    private char nextChar()
    {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length())
            index = 0;
        return c;
    }
}



