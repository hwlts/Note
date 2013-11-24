package WeakPoint.MultiThread_Design_Pattern.Single_Threaded_Execution;

public class Gate
{
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String address)
    {
        this.counter++;
        this.name = name;
        Thread.yield();
        this.address = address;
        Thread.yield();
        check();
    }

    public synchronized String toString()
    {
        return "No." + counter + ": " + name + ", " + address;
    }

    private void check()
    {
        if (name.charAt(0) != address.charAt(0))
            System.out.println("***BROKEN***" + toString());
    }
}
