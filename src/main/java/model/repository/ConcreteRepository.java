package model.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ConcreteRepository<T> implements Repository<T>{
    
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public ConcreteRepository(EntityManagerFactory emf, EntityManager em) {
        this.emf = emf;
        this.em = em;
    }
    
    @Override
    public T retrieve(Query query) throws NoResultException{
        return (T) query.getSingleResult();
    }

    @Override
    public void persist(T object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id, Class c) {
        T e = (T) em.find(c, id);
        if(e != null){
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }
    }

    @Override
    public List<T> retriveMany(Query query) throws NoResultException {
        return query.getResultList();
    }

    @Override
    public void update(T object) {
        em.getTransaction().begin();
        em.merge(object); 
        em.getTransaction().commit();
    }
    
}
