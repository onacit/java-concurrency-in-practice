package com.github.onacit.book.jcip.chapter01;

import com.github.onacit.book.jcip.ThreadSafe;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

import static com.github.onacit.book.jcip.chapter01.FactorUtils.factor;

@ThreadSafe
public class StatelessFactorizer extends AbstractServlet {

    @Override
    public void service(final ServletRequest req, final ServletResponse resp) throws ServletException, IOException {
        final var i = extractFromRequest(req);
        final var factors = factor(i);
        encodeIntoResponse(resp, factors);
    }
}
