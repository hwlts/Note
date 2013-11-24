package WeakPoint.Thinking_In_Java.concurrency;


public class MainThread
{
    public static void main(String[] args)
    {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
