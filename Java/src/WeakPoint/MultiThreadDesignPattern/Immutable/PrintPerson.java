package WeakPoint.MultiThreadDesignPattern.Immutable;

public class PrintPerson extends Thread
{
    private Person person;

    public PrintPerson(Person person)
    {
        this.person = person;
    }

    public void run()
    {
        while (true)
        {
            System.out.println(Thread.currentThread().getName() + " prints " + person);
        }
    }
}
