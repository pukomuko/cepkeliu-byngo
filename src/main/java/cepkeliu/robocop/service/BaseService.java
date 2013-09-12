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

}
