package khainy.khainyspring.spring_event.event;

public interface EventT {
    record AfterCommit(
        String name
    ) {
    }

    record AfterRollback(
        String name
    ) {
    }

    record AfterCompletion(
        String name
    ) {
    }
}

