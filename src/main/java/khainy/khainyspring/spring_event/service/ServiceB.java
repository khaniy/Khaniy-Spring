package khainy.khainyspring.spring_event.service;

import khainy.khainyspring.spring_event.event.AsyncEventX;
import khainy.khainyspring.spring_event.event.EventX;
import khainy.khainyspring.util.ThreadUtil;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ServiceB {

    public void doSomethingB(String name) {
        ThreadUtil.sleep(1000);
        System.out.println(name + " do Something B");
    }

    @EventListener
    public void doEventX(EventX eventX) {
        ThreadUtil.sleep(1000);
        System.out.println(eventX.name() + " do Something B");
    }

    @Async
    @EventListener
    public void doAsyncEventX(AsyncEventX eventX) {
        ThreadUtil.sleep(1000);
        System.out.println(eventX.name() + " do Something B");
    }

}
