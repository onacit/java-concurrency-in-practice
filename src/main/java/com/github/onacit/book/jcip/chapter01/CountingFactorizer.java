package com.github.onacit.book.jcip.chapter01;

import com.github.onacit.book.jcip.ThreadSafe;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import static com.github.onacit.book.jcip.chapter01.FactorUtils.factor;

@ThreadSafe
public class CountingFactorizer extends AbstractServlet {

    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    @Override
    public void service(final ServletRequest req, final ServletResponse resp) throws ServletException, IOException {
        final var i = extractFromRequest(req);
        final var factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(resp, factors);
    }
}
