package khainy.khainyspring.spring_event.service;

import khainy.khainyspring.spring_event.event.AsyncEventX;
import khainy.khainyspring.spring_event.event.EventX;
import khainy.khainyspring.util.ThreadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceA {

    public void doSomethingA(String name) {
        ThreadUtil.sleep(1000);
        System.out.println(name + " do Something A");
    }

    @EventListener
    public void doEventX(EventX eventX) {
        ThreadUtil.sleep(1000);
        System.out.println(eventX.name() + " do Something A");
    }

    @Async
    @EventListener
    public void doAsyncEventX(AsyncEventX eventX) {
        ThreadUtil.sleep(1000);
        System.out.println(eventX.name() + " do Something A");
    }
}
