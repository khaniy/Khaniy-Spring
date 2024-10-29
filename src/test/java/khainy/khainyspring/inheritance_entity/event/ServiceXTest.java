package khainy.khainyspring.inheritance_entity.event;

import khainy.khainyspring.spring_event.event.AsyncEventX;
import khainy.khainyspring.spring_event.event.EventT;
import khainy.khainyspring.spring_event.service.ServiceT;
import khainy.khainyspring.spring_event.service.ServiceX;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

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


        }

        @Test
        @DisplayName("X를 비동기 이벤트로 실행한다.")
        void doAsyncEventX() {
            serviceX.doAsyncEventX("Khainy");

            assertThat(applicationEvents.stream(AsyncEventX.class).count()).isEqualTo(1);
        }

    }

    @Nested
    @DisplayName("트랜잭션 컨텍스트 내부에서의 이벤트 테스트")
    class case2 {

        @MockBean
        private ServiceT serviceT;
        private final String name = "Khainy";

        @DisplayName("이벤트를 트랜잭션 컨텍스트 없이 실행한다.")
        @Test
        void doTransactionalEventWithoutTransaction() {
            serviceX.doTransactionalEventWithoutTransaction(name);
            serviceX.doTransactionalEvent(name);
            serviceX.doTransactionEventWithException(name);

//            assertAll(() -> {
//                assertThat(applicationEvents.stream(EventT.AfterCommit.class).count()).isEqualTo(1);
//                verify(serviceT, never()).listenEvent(any(EventT.AfterCommit.class));
//
//                assertThat(applicationEvents.stream(EventT.AfterCompletion.class).count()).isEqualTo(1);
//                verify(serviceT, never()).listenEvent(any(EventT.AfterCompletion.class));
//
//                assertThat(applicationEvents.stream(EventT.AfterRollback.class).count()).isEqualTo(1);
//                verify(serviceT, never()).listenEvent(any(EventT.AfterRollback.class));
//            });
        }

        @DisplayName("이벤트를 트랜잭션 컨텍스트 안에서 실행한다.")
        @Test
        void doTransactionalEvent() {

            serviceX.doTransactionalEvent(name);

//            assertAll(() -> {
//                assertThat(applicationEvents.stream(EventT.AfterCommit.class).count()).isEqualTo(1);
//                verify(serviceT, times(1)).listenEvent(any(EventT.AfterCommit.class));
//
//                assertThat(applicationEvents.stream(EventT.AfterCompletion.class).count()).isEqualTo(1);
//                verify(serviceT, times(1)).listenEvent(any(EventT.AfterCompletion.class));
//
//                assertThat(applicationEvents.stream(EventT.AfterRollback.class).count()).isEqualTo(1);
//                verify(serviceT, never()).listenEvent(any(EventT.AfterRollback.class));
//
//            });
        }

        @DisplayName("이벤트를 트랜잭션 컨텍스트에서 예외와 함께 실행한다.")
        @Test
        void doTransactionalEventWithException() {

            serviceX.doTransactionEventWithException(name);

//            assertAll(() -> {
//                assertThat(applicationEvents.stream(EventT.AfterCommit.class).count()).isEqualTo(1);
//                verify(serviceT, never()).listenEvent(any(EventT.AfterCommit.class));
//
//                assertThat(applicationEvents.stream(EventT.AfterCompletion.class).count()).isEqualTo(1);
//                verify(serviceT, times(1)).listenEvent(any(EventT.AfterCompletion.class));
//
//                assertThat(applicationEvents.stream(EventT.AfterRollback.class).count()).isEqualTo(1);
//                verify(serviceT, times(1)).listenEvent(any(EventT.AfterRollback.class));
//            });
        }
    }
}