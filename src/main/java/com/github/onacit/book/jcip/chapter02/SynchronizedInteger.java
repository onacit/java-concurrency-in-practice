package com.github.onacit.book.jcip.chapter02;

import com.github.onacit.book.jcip.GuardedBy;
import com.github.onacit.book.jcip.ThreadSafe;

@ThreadSafe
class SynchronizedInteger {

    @GuardedBy("this")
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(final int value) {
        this.value = value;
    }
}
