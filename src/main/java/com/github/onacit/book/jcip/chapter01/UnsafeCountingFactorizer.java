package com.github.onacit.book.jcip.chapter01;

import com.github.onacit.book.jcip.NotThreadSafe;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

import static com.github.onacit.book.jcip.chapter01.FactorUtils.factor;

@NotThreadSafe
public class UnsafeCountingFactorizer extends AbstractServlet {

    private long count = 0;

    public long getCount() {
        return count;
    }

    @Override
    public void service(final ServletRequest req, final ServletResponse resp) throws ServletException, IOException {
        final var i = extractFromRequest(req);
        final var factors = factor(i);
        ++count;
        encodeIntoResponse(resp, factors);
    }
}
