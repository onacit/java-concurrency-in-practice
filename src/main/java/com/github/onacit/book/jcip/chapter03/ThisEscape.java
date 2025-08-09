package com.github.onacit.book.jcip.chapter03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ThisEscape {

    static class Event {

    }

    interface EventListener {

        void onEvent(Event e);
    }

    static class EventSource {

        void registerListener(final EventListener listener) {
            log.debug("registerListener({})", listener);
        }
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    ThisEscape(final EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(final Event e) {
                doSomething(e);
            }
        });
        log.debug("end of constructor");
    }

    // -----------------------------------------------------------------------------------------------------------------
    void doSomething(final Event e) {
        log.debug("doSomething({})", e);
    }
}
