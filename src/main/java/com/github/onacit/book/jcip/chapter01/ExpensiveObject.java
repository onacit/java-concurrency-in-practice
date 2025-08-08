package com.github.onacit.book.jcip.chapter01;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

class ExpensiveObject {

    ExpensiveObject() {
        super();
        try {
            Thread.sleep(Duration.ofSeconds(ThreadLocalRandom.current().nextLong(10)));
        } catch (final InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
