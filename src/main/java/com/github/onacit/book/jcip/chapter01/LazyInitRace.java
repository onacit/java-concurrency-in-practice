package com.github.onacit.book.jcip.chapter01;

import com.github.onacit.book.jcip.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {

    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }
}
