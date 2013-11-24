package WeakPoint.MultiThread_Design_Pattern.Guarded_Suspension;

import java.util.LinkedList;

public class RequestQueue
{
    private final LinkedList<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest()
    {
        while (queue.size() <= 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {}
        }

        return queue.removeFirst();
    }

    public synchronized void putRequest(Request request)
    {
        queue.add(request);
        notifyAll();
    }
}


