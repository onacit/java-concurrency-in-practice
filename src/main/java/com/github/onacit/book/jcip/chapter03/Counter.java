package com.github.onacit.book.jcip.chapter03;

import com.github.onacit.book.jcip.GuardedBy;

final class Counter {

    @GuardedBy("this")
    private long value = 0;

    synchronized long getValue() {
        return value;
    }

    synchronized long increment() {
        if (value == Long.MAX_VALUE)
            throw new IllegalStateException("counter overflow");
        return ++value;
    }
}
