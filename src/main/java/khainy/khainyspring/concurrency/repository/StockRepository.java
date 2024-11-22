package khainy.khainyspring.concurrency.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StockRepository extends CrudRepository<StockEntity, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT m FROM StockEntity m WHERE m.id =:id")
    Optional<StockEntity> findByIdWithPessimisticLock(Long id);

    @Lock(LockModeType.OPTIMISTIC)
    @Query("SELECT m FROM StockEntity m WHERE m.id =:id")
    Optional<StockEntity> findByIdWithOptimisticLock(Long id);
}
