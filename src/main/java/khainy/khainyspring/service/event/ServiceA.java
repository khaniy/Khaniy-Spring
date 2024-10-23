package khainy.khainyspring.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceA {

    public void doSomethingA(String name) {
        System.out.println(name + " do Something A");
    }

    @EventListener
    public void doEventX(EventX eventX) {
        System.out.println(eventX.name() + " do Something A");
    }

    @Async
    @EventListener
    public void doAsyncEventX(AsyncEventX eventX) {
        System.out.println(eventX.name() + " do Something A");
    }
}
