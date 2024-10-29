package khainy.khainyspring.spring_event.service;

import khainy.khainyspring.spring_event.event.AsyncEventX;
import khainy.khainyspring.spring_event.event.EventT;
import khainy.khainyspring.spring_event.event.EventX;
import khainy.khainyspring.spring_event.event.TransactionalEventX;
import khainy.khainyspring.util.ThreadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ServiceX {

    private final ServiceA serviceA;
    private final ServiceB serviceB;
    private final ServiceC serviceC;
    private final ApplicationEventPublisher applicationEventPublisher;

    public void doSomethingX(String name) {
        System.out.println("Actor is " + name);
        System.out.println("===== Start (Sync) =====");
        ThreadUtil.sleep(1000); //1초 지연

        serviceA.doSomethingA(name); // A
        serviceB.doSomethingB(name); // B
        serviceC.doSomethingC(name); // C
    }


    public void doEventX(String name) {
        System.out.println("Actor is " + name);
        System.out.println("===== Start (Event) =====");
        ThreadUtil.sleep(1000); //1초 지연

        applicationEventPublisher.publishEvent(new EventX(name));
    }

    public void doAsyncEventX(String name) {
        System.out.println("Actor is " + name);
        System.out.println("===== Start (Async Event) =====");
        ThreadUtil.sleep(1000); //1초 지연

        applicationEventPublisher.publishEvent(new AsyncEventX(name));
    }
    //

    @Transactional
    public void doTransactionalEvent(String name) {
        System.out.println("===== Start (Transactional Event) =====");
        System.out.println("Actor is " + name);

        applicationEventPublisher.publishEvent(new EventT.AfterCommit(name));
        applicationEventPublisher.publishEvent(new EventT.AfterRollback(name));
        applicationEventPublisher.publishEvent(new EventT.AfterCompletion(name));
    }

    public void doTransactionalEventWithoutTransaction(String name) {
        System.out.println("===== Start (No Transactional Event) =====");
        System.out.println("Actor is " + name);

        applicationEventPublisher.publishEvent(new EventT.AfterCommit(name));
        applicationEventPublisher.publishEvent(new EventT.AfterRollback(name));
        applicationEventPublisher.publishEvent(new EventT.AfterCompletion(name));
    }

    @Transactional
    public void doTransactionEventWithException(String name) {
        System.out.println("===== Start (Transactional Event With Exception) =====");
        System.out.println("Actor is " + name);

        applicationEventPublisher.publishEvent(new EventT.AfterCommit(name));
        applicationEventPublisher.publishEvent(new EventT.AfterRollback(name));
        applicationEventPublisher.publishEvent(new EventT.AfterCompletion(name));
        throw new RuntimeException("Exception occurred");
    }
}