package project1.reesebenson.ProcessUtils;

public interface IPipeLine<T> {  
    
    public T runall();
    
    public boolean compile ();

    public boolean test ();

    public boolean push ();
}