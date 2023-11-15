package lab05.java_technology.Repository;

import java.util.List;

public interface Repository<T, K>{
    public boolean add(T item);
    public T findByName(String name);
    public T findById(K id);
    public List<T> getAll();
    public boolean remove(K id);
    public boolean update(T item);
}
