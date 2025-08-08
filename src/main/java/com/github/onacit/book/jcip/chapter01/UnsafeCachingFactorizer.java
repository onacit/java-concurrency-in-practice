package com.github.onacit.book.jcip.chapter01;

import com.github.onacit.book.jcip.NotThreadSafe;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import static com.github.onacit.book.jcip.chapter01.FactorUtils.factor;

@NotThreadSafe
public class UnsafeCachingFactorizer extends AbstractServlet {

    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();

    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

    @Override
    public void service(final ServletRequest req, final ServletResponse resp) throws ServletException, IOException {
        final var i = extractFromRequest(req);
        if (i.equals(lastNumber.get())) {
            encodeIntoResponse(resp, lastFactors.get());
        } else {
            final var factors = factor(i);
            lastNumber.set(i);        // <<<<<<<<<<<<<<<<<<<<<<<<<<
            lastFactors.set(factors); // <<<<<<<<<<<<<<<<<<<<<<<<<<
            encodeIntoResponse(resp, factors);
        }
    }
}
