package cepkeliu.robocop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cepkeliu.robocop.model.Meeting;

@Service
public class MeetingsService extends BaseService {

    @Transactional(readOnly = true)
    public List<Meeting> getAll() {
        return em.createQuery("from Meeting", Meeting.class).getResultList();
    }
    
}
