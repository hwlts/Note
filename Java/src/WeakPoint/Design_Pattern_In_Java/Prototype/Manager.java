package WeakPoint.Design_Pattern_In_Java.Prototype;

import java.util.Hashtable;

public class Manager
{
    private Hashtable showcase = new Hashtable();

    public void register(String name, Product proto)
    {
        showcase.put(name,proto);
    }

    public Product create(String protoname)
    {
        Product p = (Product) showcase.get(protoname);
        return p.createClone();
    }
}
