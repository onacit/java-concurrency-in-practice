package com.github.onacit.book.jcip.chapter01;

import java.math.BigInteger;
import java.util.ArrayList;

final class FactorUtils {

    private static final BigInteger TWO = BigInteger.valueOf(2);

    private static final BigInteger THREE = BigInteger.valueOf(3);

    static BigInteger[] factor(BigInteger n) {
        final var factors = new ArrayList<BigInteger>();
        while (n.mod(TWO).equals(BigInteger.ZERO)) {
            factors.add(TWO);
            n = n.divide(TWO);
        }
        for (BigInteger i = THREE; i.multiply(i).compareTo(n) <= 0; i = i.add(TWO)) {
            while (n.mod(i).equals(BigInteger.ZERO)) {
                factors.add(i);
                n = n.divide(i);
            }
        }
        if (n.compareTo(BigInteger.ONE) > 0) {
            factors.add(n);
        }
        return factors.toArray(new BigInteger[0]);
    }

    private FactorUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
