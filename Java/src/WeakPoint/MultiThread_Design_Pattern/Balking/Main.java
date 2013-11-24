package WeakPoint.MultiThread_Design_Pattern.Balking;

public class Main
{
    public static void main(String[] args)
    {
        Data data = new Data("data.txt","(empty)");

        new ChangerThread("ChangerThread",data).start();
        new SaverThread("SaverThread",data).start();
    }
}
