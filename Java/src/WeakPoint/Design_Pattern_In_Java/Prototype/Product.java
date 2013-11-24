package WeakPoint.Design_Pattern_In_Java.Prototype;

public interface Product extends Cloneable
{
    public void use(String s);
    public Product createClone();
}
