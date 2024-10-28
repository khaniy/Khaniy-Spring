package khainy.khainyspring.service.event;

import khainy.khainyspring.spring_event.event.AsyncEventX;
import khainy.khainyspring.spring_event.event.EventX;
import khainy.khainyspring.spring_event.service.ServiceA;
import khainy.khainyspring.spring_event.service.ServiceB;
import khainy.khainyspring.spring_event.service.ServiceC;
import khainy.khainyspring.spring_event.service.ServiceX;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RecordApplicationEvents
class ServiceXTest {

    @Autowired
    private ServiceX serviceX;
    @Autowired
    private ApplicationEvents applicationEvents;
//    @MockBean
//    private ServiceA serviceA;
//    @MockBean
//    private ServiceB serviceB;
//    @MockBean
//    private ServiceC serviceC;


    @Nested
    @DisplayName("X 실행")
    class case1 {
        @Test
        @DisplayName("X를 동기적으로 실행한다.")
        void doSomethingX() {
            serviceX.doSomethingX("Khainy");
        }

        @Test
        @DisplayName("X를 이벤트로 실행한다.")
        void doEventX() {
            serviceX.doEventX("Khainy");

//            Assertions.assertAll(()->{
//                assertThat(applicationEvents.stream(EventX.class).count()).isEqualTo(1);
//                Mockito.verify(serviceA).doEventX(Mockito.any());
//            });
        }

        @Test
        @DisplayName("X를 비동기 이벤트로 실행한다.")
        void doAsyncEventX() {
            serviceX.doAsyncEventX("Khainy");

            assertThat(applicationEvents.stream(AsyncEventX.class).count()).isEqualTo(1);
        }

    }

}