package com.github.onacit.book.jcip.chapter03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SafeListener {

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS
    static SafeListener newInstance(final ThisEscape.EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    private SafeListener() {
        listener = new ThisEscape.EventListener() {
            @Override
            public void onEvent(final ThisEscape.Event e) {
                doSomething(e);
            }
        };
        log.debug("end of constructor");
    }

    // -----------------------------------------------------------------------------------------------------------------
    void doSomething(final ThisEscape.Event e) {
        log.debug("doSomething({})", e);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final ThisEscape.EventListener listener;
}
