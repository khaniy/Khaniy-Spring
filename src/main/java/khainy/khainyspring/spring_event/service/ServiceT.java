package khainy.khainyspring.spring_event.service;

import khainy.khainyspring.spring_event.event.AsyncEventX;
import khainy.khainyspring.spring_event.event.EventT;
import khainy.khainyspring.spring_event.event.EventX;
import khainy.khainyspring.spring_event.event.TransactionalEventX;
import khainy.khainyspring.util.ThreadUtil;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class ServiceT {

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void listenEvent(EventT.AfterCommit event) {
        System.out.println(event.name() + " do AFTER COMMIT");
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void listenEvent(EventT.AfterCompletion event) {
        System.out.println(event.name() + " do AFTER COMPLETION");
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void listenEvent(EventT.AfterRollback event) {
        System.out.println(event.name() + " do AFTER ROLLBACK");
    }
}
