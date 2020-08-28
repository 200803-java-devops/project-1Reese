package project1.reesebenson.DB.Dao;

public interface IDao<E, T> {
    public E get(T id);
    public void delete(E entity);
    public void create(E entity);
    public void update(E entity);
}