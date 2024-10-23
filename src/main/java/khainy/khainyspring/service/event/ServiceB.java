package khainy.khainyspring.service.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Timer;

@Service
public class ServiceB {

    public void doSomethingB(String name) {
        System.out.println(name + " do Something B");
    }

    @EventListener
    public void doEventX(EventX eventX) {
        System.out.println(eventX.name() + " do Something B");
    }

    @Async
    @EventListener
    public void doAsyncEventX(AsyncEventX eventX) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(eventX.name() + " do Something B");
    }

}
