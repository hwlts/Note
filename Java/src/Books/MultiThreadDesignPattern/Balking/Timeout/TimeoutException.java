package Books.MultiThreadDesignPattern.Balking.Timeout;

public class TimeoutException extends InterruptedException
{
    public TimeoutException(String msg)
    {
        super(msg);
    }
}
