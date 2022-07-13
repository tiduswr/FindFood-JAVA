package model.repository;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public interface Repository<T> {
    public T retrieve(Query query) throws NoResultException;
    public void persist(T object);
    public void update(T object);
    public void delete(long id, Class c);
    public List<T> retriveMany(Query query) throws NoResultException;
}
