package com.github.onacit.book.jcip.chapter01;

import com.github.onacit.book.jcip.GuardedBy;
import com.github.onacit.book.jcip.NotThreadSafe;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.math.BigInteger;

import static com.github.onacit.book.jcip.chapter01.FactorUtils.factor;

@NotThreadSafe
public class CachedFactorizer extends AbstractServlet {

    @GuardedBy("this")
    private BigInteger lastNumber;

    @GuardedBy("this")
    private BigInteger[] lastFactors;

    @GuardedBy("this")
    private long hits;

    @GuardedBy("this")
    private long cachedHist;

    @Override
    public synchronized void service(final ServletRequest req, final ServletResponse resp)
            throws ServletException, IOException {
        final var i = extractFromRequest(req);
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            ++cachedHist;
            if (i.equals(lastNumber)) {
                ++cachedHist;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factor(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
        encodeIntoResponse(resp, factors);
    }
}
