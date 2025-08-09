package com.github.onacit.book.jcip.chapter03;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

class CounterTest {

    @Test
    void __() {
        final var counter = new Counter();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            final int count = 10000;
            for (int i = 0; i < count; i++) {
                executor.submit(counter::increment);
            }
            assertThat(counter.getValue()).isEqualTo(count);
        }
    }
}