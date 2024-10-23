package khainy.khainyspring.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceX {

    private final ServiceA serviceA;
    private final ServiceB serviceB;
    private final ServiceC serviceC;

    public void doSomethingX(String name) {
        System.out.println("Actor is " + name);
        System.out.println("===== start =====");

        serviceA.doSomethingA(name); // A
        serviceB.doSomethingB(name); // B
        serviceC.doSomethingC(name); // C
    }

    private final ApplicationEventPublisher applicationEventPublisher;

    public void doEventX(String name) {
        System.out.println("Actor is " + name);
        System.out.println("===== start =====");

        applicationEventPublisher.publishEvent(new EventX(name));
    }

    public void doAsyncEventX(String name) {
        System.out.println("Actor is " + name);
        System.out.println("===== start =====");

        applicationEventPublisher.publishEvent(new AsyncEventX(name));
    }
}