package WeakPoint.Design_Pattern_In_Java.Factory_Method;

public abstract class Factory
{
    public final Product create(String owner)
    {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
