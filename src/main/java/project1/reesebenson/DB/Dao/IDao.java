package project1.reesebenson.DB.Dao;

import java.util.List;

public interface IDao<E, T> {
    public List<E>get();
    public E get(T id);
    public void delete(E entity);
    public void create(E entity);
    public void update(E entity);
}