package WeakPoint.MultiThread_Design_Pattern.Immutable;

public class Main
{
    public static void main(String[] args)
    {
        Person alice = new Person("Alice","Alaska");

        new PrintPerson(alice).start();
        new PrintPerson(alice).start();
        new PrintPerson(alice).start();
    }
}
