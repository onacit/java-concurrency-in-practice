package com.github.onacit.book.jcip.chapter02;

import com.github.onacit.book.jcip.NotThreadSafe;

@NotThreadSafe
class MutableInteger {

    private int value;

    public int get() {
        return value;
    }

    public void set(final int value) {
        this.value = value;
    }
}
