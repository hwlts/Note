package WeakPoint.MultiThread_Design_Pattern.Balking.Timeout;

public class TimeoutException extends InterruptedException
{
    public TimeoutException(String msg)
    {
        super(msg);
    }
}
