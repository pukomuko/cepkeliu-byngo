package cepkeliu.robocop.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public class BaseService {

    @PersistenceContext
    protected EntityManager em;

    @Transactional(readOnly = true)
    public <T> T getById(final Long id, final Class<T> type) {
        return em.find(type, id);
    }
    
    @Transactional
    public <T> T save(final T entity, final Class<T> type) {
        em.persist(entity);
        return entity;
    }

}
