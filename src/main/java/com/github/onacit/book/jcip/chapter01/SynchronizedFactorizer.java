package com.github.onacit.book.jcip.chapter01;

import com.github.onacit.book.jcip.GuardedBy;
import com.github.onacit.book.jcip.ThreadSafe;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import static com.github.onacit.book.jcip.chapter01.FactorUtils.factor;

@ThreadSafe
public class SynchronizedFactorizer extends AbstractServlet {

    @GuardedBy("this")
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();

    @GuardedBy("this")
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

    @Override
    public synchronized void service(final ServletRequest req, final ServletResponse resp)
            throws ServletException, IOException {
        final var i = extractFromRequest(req);
        if (i.equals(lastNumber.get())) {
            encodeIntoResponse(resp, lastFactors.get());
        } else {
            final var factors = factor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
            encodeIntoResponse(resp, factors);
        }
    }
}
