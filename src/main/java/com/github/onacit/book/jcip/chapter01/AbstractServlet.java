package com.github.onacit.book.jcip.chapter01;

import jakarta.annotation.Nonnull;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
abstract class AbstractServlet extends GenericServlet {

    @Nonnull
    static BigInteger extractFromRequest(@Nonnull final ServletRequest req) {
        return null;
    }

    static void encodeIntoResponse(@Nonnull final ServletResponse resp, @Nonnull final BigInteger[] factors) {
    }
}
