package khainy.khainyspring.spring_event.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventRepository {
    private final EntityManager em;

    public void save(EventEntity entity) {
        if (entity.getId() == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
    }

    public EventEntity findById(Long id) {
        return em.createQuery("select e from EventEntity e where e.id=:eventId", EventEntity.class)
            .setParameter("eventId", 1)
            .getSingleResult();
    }
}
