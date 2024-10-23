package khainy.khainyspring.service.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ServiceC {

    public void doSomethingC(String name) {
        System.out.println(name + " do Something C");
    }

    @EventListener
    public void doEventX(EventX eventX) {
        System.out.println(eventX.name() + " do Something C");
    }

    @Async
    @EventListener
    public void doAsyncEventX(AsyncEventX eventX) {
        System.out.println(eventX.name() + " do Something C");
    }

}
