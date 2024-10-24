package khainy.khainyspring.service.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.RecordApplicationEvents;

@SpringBootTest
@RecordApplicationEvents
class ServiceXTest {

    @Autowired
    private ServiceX serviceX;

    @Test
    @DisplayName("X를 동기적으로 실행한다.")
    void doSomethingX() {
        serviceX.doSomethingX("Khainy");
    }

    @Test
    @DisplayName("X를 이벤트로 실행한다.")
    void doEventX() {
        serviceX.doEventX("Khainy");
    }

    @Test
    @DisplayName("X를 이벤트로 실행한다.")
    void doAsyncEventX() {
        serviceX.doAsyncEventX("Khainy");
    }
}