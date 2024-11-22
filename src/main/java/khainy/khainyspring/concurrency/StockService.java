package khainy.khainyspring.concurrency;


import khainy.khainyspring.concurrency.repository.StockEntity;
import khainy.khainyspring.concurrency.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    @Transactional
    public void decrease(Long id){
        StockEntity stock = stockRepository.findById(id)
            .orElseThrow();
        stock.decrease();
    }

    @Transactional
    public void decreaseWithLock(Long id){
        StockEntity stock = stockRepository.findByIdWithPessimisticLock(id)
            .orElseThrow();
        stock.decrease();
    }
}
